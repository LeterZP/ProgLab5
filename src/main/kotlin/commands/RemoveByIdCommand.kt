package commands

import core.CommandInvoker
import exceptions.InvalidElementValueException

class RemoveByIdCommand(ci: CommandInvoker): Command(ci) {
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
        var value: Long
        try {value = token[0].toLong()}
        catch (e: NumberFormatException) {throw InvalidElementValueException(token[0])}
        ci.cm.removeElement(value)
        println("Элемент $value успешно удалён.")
    }

    override fun describe(): String {
        return "Удаляет элемент по его id"
    }

    override fun getSyntax(): String {
        return "[id]"
    }

    override fun getName(): String {
        return "remove_by_id"
    }
}