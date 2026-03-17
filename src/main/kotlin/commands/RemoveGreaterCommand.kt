package commands

import core.CommandInvoker
import exceptions.InvalidElementValueException

class RemoveGreaterCommand(ci: CommandInvoker): Command(ci){
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
        try {
            ci.cm.removeGreater(token[0].toLong())
        } catch (e: NumberFormatException) {
            throw InvalidElementValueException(token[0])
        }
    }

    override fun describe(): String {
        return "Удаляет элементы коллекции больше заданного"
    }

    override fun getSyntax(): String {
        return "[id]"
    }

    override fun getName(): String {
        return "remove_greater"
    }
}