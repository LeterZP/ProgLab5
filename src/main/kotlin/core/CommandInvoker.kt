package core

import commands.*
import exceptions.CommandNotFoundException

class CommandInvoker(val cm: CollectionManager) {
    val commands: HashMap<String, Command> = HashMap()

    init {
        initializeCommand(HelpCommand(this))
        initializeCommand(InfoCommand(this))
        initializeCommand(ShowCommand(this))
    }

    fun initializeCommand(command: Command) {
        val name: String = command.getName()
        commands[name] = command
    }

    fun readCommand() {
        val instruction: List<String> = readln().split(" ")
        commands.get(instruction[0])?.execute(instruction.minus(instruction[0])) ?: throw CommandNotFoundException(instruction[0])
    }
}