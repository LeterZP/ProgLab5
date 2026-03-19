package commands

import core.CommandInvoker
import exceptions.CollectionHasNoElementException

class RemoveLastCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        try {
            ci.cm.removeLast()
            println("Элемент успешно удалён.")
        } catch (e: CollectionHasNoElementException) {
            println("Последний элемент не найден: коллекция пуста.")
        }
    }

    override fun describe(): String {
        return "Удаляет последний элемент коллекции"
    }

    override fun getName(): String {
        return "remove_last"
    }
}