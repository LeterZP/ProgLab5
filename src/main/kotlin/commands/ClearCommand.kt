package commands

import core.CollectionManager
import io.IOManager

/**
 * Команда для очистки коллекции.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class ClearCommand(io: IOManager, cm: CollectionManager): Command(io, cm) {
    override fun execute(token: List<String>) {
        super.execute(token)
        cm.clearCollection()
        io.write("Коллекция отчищена." + "\n")
    }

    override fun describe(): String {
        return "Удаляет все элементы коллекции"
    }

    override fun getName(): String {
        return "clear"
    }
}