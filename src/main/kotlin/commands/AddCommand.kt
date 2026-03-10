package commands

import core.CommandInvoker
import core.CollectionManager
import exceptions.InvalidElementValueException

class AddCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        input()
    }

    override fun getSyntax(): String {
        return "{element}"
    }

    override fun getName(): String {
        return "add"
    }

    override fun describe(): String {
        return "Добавляет элемент в коллекцию"
    }

    fun input() {
        val creator: CollectionManager.ElementCreator = ci.cm.ElementCreator()
        var count: Int = 0

        while (true) {
            print("Введите ")
            print(creator.creator.getField(count))
            print(": ")
            val value: String = ci.readNext()
            try {
                creator.addValue(value, count)
            } catch (e: InvalidElementValueException) {
                println(e.message)
                continue
            }
            if (count == creator.creator.size-1) break
            count++
        }
        println("Элемент успешно добавлен")
    }
}