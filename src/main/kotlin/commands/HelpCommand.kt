package commands

import core.CollectionManager
import core.CommandInvoker
import exceptions.CommandNotFoundException
import exceptions.InvalidAmountOfArgumentsException
import io.IOManager

/**
 * Команда для вывода списка доступных команд.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 * @param ci [CommandInvoker] с командами.
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class HelpCommand(io: IOManager, cm: CollectionManager, private val ci: CommandInvoker): Command(io, cm) {
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
                io.write("Список доступных команд:" + "\n")
                for (command in ci.commands.values) {
                    io.write(getInfo(command) + "\n")
                }
            } else if (token.size == 1) {
                if (token[0] in ci.commands.keys) {
                    io.write(getFullInfo(ci.commands.get(token[0])!!) + "\n")
                } else {
                    throw CommandNotFoundException(token[0])
                }
            } else throw InvalidAmountOfArgumentsException(this, token.size)
        } catch (e: CommandNotFoundException) {
            io.write(e.message + "\n")
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