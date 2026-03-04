package core

import commands.*
import exceptions.CommandNotFoundException

class CommandInvoker(cm: CollectionManager) {
    val commands: HashMap<String, Command> = HashMap()

    init{
        initializeCommand(InfoCommand(cm))
    }

    fun initializeCommand(command: Command) {
        val name: String = command.toString()
        commands[name] = command
    }

    fun readCommand() {
        val instruction: List<String> = readln().split(" ")
        commands.get(instruction[0])?.execute(instruction.minus(instruction[0])) ?:
        throw CommandNotFoundException(instruction[0])
    }
}