package commands

import core.CommandInvoker
import java.io.IOException

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