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
        println("Информация о коллекции:")
        println("  --Тип коллекции: java.util.Stack")
        println("  --Дата инициализации коллекции: $time")
        println("  --Количество элементов в коллекции: $size")
    }

    override fun getName(): String {
        return "info"
    }
}