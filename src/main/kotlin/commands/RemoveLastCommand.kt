package commands

import core.CollectionManager
import exceptions.CollectionHasNoElementException
import io.IOManager

/**
 * Команда для удаления последнего элемента коллекции.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class RemoveLastCommand(io: IOManager, cm: CollectionManager): Command(io, cm) {
    override fun execute(token: List<String>) {
        super.execute(token)
        try {
            cm.removeLast()
            io.write("Элемент успешно удалён.\n")
        } catch (e: CollectionHasNoElementException) {
            io.write("Последний элемент не найден: коллекция пуста.\n")
        }
    }

    override fun describe(): String {
        return "Удаляет последний элемент коллекции"
    }

    override fun getName(): String {
        return "remove_last"
    }
}