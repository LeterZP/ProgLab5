package commands

import core.CommandInvoker

/**
 * Команда для получения информации о коллекции.
 *
 * @param ci [CommandInvoker], который вызывает команду.
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class InfoCommand(ci: CommandInvoker): Command(ci) {
    override fun describe(): String {
        return "Выводит всю информацию о коллекции"
    }

    override fun execute(token: List<String>) {
        super.execute(token)
        val time = ci.cm.initializationTime
        val size = ci.cm.size
        ci.printInCommandInvoker("Информация о коллекции:" + "\n")
        ci.printInCommandInvoker("  --Тип коллекции: java.util.Stack" + "\n")
        ci.printInCommandInvoker("  --Дата инициализации коллекции: $time\n")
        ci.printInCommandInvoker("  --Количество элементов в коллекции: $size\n")
    }

    override fun getName(): String {
        return "info"
    }
}