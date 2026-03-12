package core

import commands.*
import exceptions.CommandNotFoundException
import exceptions.InvalidAmountOfArgumentsException

class CommandInvoker(val cm: CollectionManager) {
    val commands: HashMap<String, Command> = HashMap()
    private val nextToken: ArrayDeque<String> = ArrayDeque()

    init {
        initializeCommand(HelpCommand(this))
        initializeCommand(InfoCommand(this))
        initializeCommand(ShowCommand(this))
        initializeCommand(AddCommand(this))
        initializeCommand(RemoveByIdCommand(this))
        initializeCommand(ClearCommand(this))
        initializeCommand(ExitCommand(this))
    }

    fun initializeCommand(command: Command) {
        val name: String = command.getName()
        commands[name] = command
    }

    fun readCommand() {
        try {
            val instruction: List<String> = readNext().split(" ")
            if (instruction.size == 1 && instruction[0] == "") return
            commands.get(instruction[0])?.execute(instruction.minus(instruction[0]))
                ?: throw CommandNotFoundException(instruction[0])
        } catch (e: CommandNotFoundException) {
            println(e.message)
        } catch (e: InvalidAmountOfArgumentsException) {
            println(e.message)
        }
    }

    fun readNext(): String {
        val result: String
        if (nextToken.isEmpty()) {
            result = readln()
        } else {
            result = nextToken.first()
            nextToken.remove(result)
        }
        return result
    }

    fun addNext(instructions: String) {
        val values: List<String> = instructions.split("\n")
        for (instruction in values) {
            if (instruction != "") {
                nextToken.add(instruction)
            }
        }
    }
}