package commands

import core.CollectionManager
import io.IOManager

/**
 * Команда для переворота коллекции.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class ReorderCommand(io: IOManager, cm: CollectionManager): Command(io, cm) {
    override fun execute(token: List<String>) {
        super.execute(token)
        cm.reorderElements()
        io.write("Коллекция успешно перевёрнута.\n")
    }

    override fun describe(): String {
        return "Переворачивает коллекцию"
    }

    override fun getName(): String {
        return "reorder"
    }
}