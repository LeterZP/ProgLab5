package commands

import core.CollectionManager
import io.IOManager

/**
 * Команда для получения информации об элементах коллекции.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class ShowCommand(io: IOManager, cm: CollectionManager): Command(io, cm) {
    override fun execute(token: List<String>) {
        super.execute(token)
        val output: String = cm.getAllElementsToString()
        if (output != "") io.write(output + "\n")
        else io.write("Коллекция пуста.\n")
    }

    override fun describe(): String {
        return "Выводит список всех элементов коллекции"
    }

    override fun getName(): String {
        return "show"
    }
}