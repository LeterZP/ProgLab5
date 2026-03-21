package commands

import core.CommandInvoker

/**
 * Команда для удаления элемента по id.
 *
 * @param ci [CommandInvoker], который вызывает команду.
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class RemoveByIdCommand(ci: CommandInvoker): Command(ci) {
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
        var value: Long
        try {
            value = token[0].toLong()
            ci.cm.removeElement(value)
            println("Элемент $value успешно удалён.")
        }
        catch (e: NumberFormatException) { println("${token[0]} не является id элемента.") }
    }

    override fun describe(): String {
        return "Удаляет элемент по его id"
    }

    override fun getSyntax(): String {
        return "[id]"
    }

    override fun getName(): String {
        return "remove_by_id"
    }
}