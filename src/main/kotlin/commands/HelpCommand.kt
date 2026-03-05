package commands

import core.CommandInvoker
import exceptions.InvalidAmountOfArgumentsException

class HelpCommand(ci: CommandInvoker): Command(ci) {
    override val tokenAmount: Int = 1

    private fun getFullInfo(command: Command) {
        println("  --" + command.toString() + " : " + command.describe())
    }

    private fun getInfo(command: Command) {
        println("  --" + command.getName() + " : " + command.describe())
    }

    override fun execute(token: List<String>) {
        if (token.isEmpty()) {
            println("Список доступных команд:")
            for (command: Command in ci.commands.values) {
                getInfo(command)
            }
        } else if (token.size == 1) {
            if (token[0] in ci.commands.keys) {
                getFullInfo(ci.commands.get(token[0])!!)
            }
        } else throw InvalidAmountOfArgumentsException(this, token.size)
    }

    override fun getName(): String {
        return "help"
    }

    override fun getSyntax(): String {
        return "[<null> | command]"
    }

    override fun describe(): String {
        return "Выводит информацию о всех командах либо описание одной команды"
    }
}