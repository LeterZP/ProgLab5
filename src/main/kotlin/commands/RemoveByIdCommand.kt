package commands

import core.CollectionManager
import io.IOManager

/**
 * Команда для удаления элемента по id.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class RemoveByIdCommand(io: IOManager, cm: CollectionManager): Command(io, cm) {
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
        var value: Long
        try {
            value = token[0].toLong()
            cm.removeElement(value)
            io.write("Элемент $value успешно удалён.\n")
        }
        catch (e: NumberFormatException) { io.write("${token[0]} не является id элемента.\n") }
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