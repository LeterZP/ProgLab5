package commands

import core.CollectionManager
import io.IOManager
import java.io.IOException

/**
 * Команда для сохранения коллекции в файл.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class SaveCommand(io: IOManager, cm: CollectionManager): Command(io, cm) {
    override fun execute(token: List<String>) {
        super.execute(token)
        try {
            cm.saveToFile()
            io.write("Коллекция успешно сохранена.\n")
        } catch (e: IOException) {
            io.write("Файл сохранения не найден. Коллекция не сохранена.\n")
        }
    }

    override fun describe(): String {
        return "Сохраняет коллекцию в файл"
    }

    override fun getName(): String {
        return "save"
    }
}