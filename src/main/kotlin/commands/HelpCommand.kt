package commands

import core.CommandInvoker
import exceptions.CommandNotFoundException
import exceptions.InvalidAmountOfArgumentsException

/**
 * Команда для вывода списка доступных команд.
 *
 * @param ci [CommandInvoker], который вызывает команду.
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class HelpCommand(ci: CommandInvoker): Command(ci) {
    override val tokenAmount: Int = 1

    /**
     * Выдаёт полную информацию о команде.
     *
     * @param command Команда типа [Command].
     *
     * @return Информацию о команде типа [String].
     *
     * @since 1.0
     */
    private fun getFullInfo(command: Command): String {
        return "  --" + command.toString() + " : " + command.describe()
    }

    /**
     * Выдаёт краткую информацию о команде.
     *
     * @param command Команда типа [Command].
     *
     * @return Информацию о команде типа [String].
     *
     * @since 1.0
     */
    private fun getInfo(command: Command): String {
        return "  --" + command.getName() + " : " + command.describe()
    }

    override fun execute(token: List<String>) {
        try {
            if (token.isEmpty()) {
                println("Список доступных команд:")
                for (command in ci.commands.values) {
                    println(getInfo(command))
                }
            } else if (token.size == 1) {
                if (token[0] in ci.commands.keys) {
                    println(getFullInfo(ci.commands.get(token[0])!!))
                } else {
                    throw CommandNotFoundException(token[0])
                }
            } else throw InvalidAmountOfArgumentsException(this, token.size)
        } catch (e: CommandNotFoundException) {
            println(e.message)
        }
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