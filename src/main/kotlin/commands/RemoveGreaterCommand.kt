package commands

import core.CommandInvoker

/**
 * Команда для удаления элементов с [id][elements.City.id] выше заданного.
 *
 * @param ci [CommandInvoker], который вызывает команду.
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class RemoveGreaterCommand(ci: CommandInvoker): Command(ci){
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
        try {
            val count: Int = ci.cm.removeGreater(token[0].toLong())
            println("Удалено $count элементов.")
        } catch (e: NumberFormatException) {
            println("${token[0]} не является id элемента.")
        }
    }

    override fun describe(): String {
        return "Удаляет элементы коллекции больше заданного"
    }

    override fun getSyntax(): String {
        return "[id]"
    }

    override fun getName(): String {
        return "remove_greater"
    }
}