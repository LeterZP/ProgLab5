package commands

import core.CollectionManager
import io.IOManager

/**
 * Команда для удаления элементов с [id][elements.City.id] выше заданного.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class RemoveGreaterCommand(io: IOManager, cm: CollectionManager): Command(io, cm){
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
        try {
            val count: Int = cm.removeGreater(token[0].toLong())
            io.write("Удалено $count элементов.\n")
        } catch (e: NumberFormatException) {
            io.write("${token[0]} не является id элемента.\n")
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