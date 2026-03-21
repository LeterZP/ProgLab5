package commands

import core.CommandInvoker
import java.io.IOException

/**
 * Команда для сохранения коллекции в файл.
 *
 * @param ci [CommandInvoker], который вызывает команду.
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class SaveCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        try {
            ci.cm.saveToFile()
            println("Коллекция успешно сохранена.")
        } catch (e: IOException) {
            println("Файл сохранения не найден. Коллекция не сохранена.")
        }
    }

    override fun describe(): String {
        return "Сохраняет коллекцию в файл"
    }

    override fun getName(): String {
        return "save"
    }
}