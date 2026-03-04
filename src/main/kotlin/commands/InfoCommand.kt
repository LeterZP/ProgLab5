package commands

import core.CollectionManager
import exceptions.InvalidAmountOfArgumentsException

class InfoCommand(private val cm: CollectionManager): Command(cm) {
    override fun describe(): String {
        return "Выводит всю информацию о коллекции"
    }

    override fun execute(token: List<String>) {
        if (token.size != tokenAmount) throw InvalidAmountOfArgumentsException(this, token.size)
        val time = cm.initializationTime
        val size = cm.getSize()
        println("Информация о коллекции:")
        println("  --Тип коллекции: java.util.Stack")
        println("  --Дата инициализации коллекции: $time")
        println("  --Количество элементов в коллекции: $size")
    }

    override fun toString(): String {
        return "info"
    }
}