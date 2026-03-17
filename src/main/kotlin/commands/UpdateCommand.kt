package commands

import core.CommandInvoker
import elements.CityBuilder
import exceptions.InvalidElementValueException
import exceptions.NoNextCommandException

class UpdateCommand(ci: CommandInvoker): Command(ci) {
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
        val id: Long
        try { id = token[0].toLong() }
        catch (_: NumberFormatException) { throw InvalidElementValueException(token[0]) }
        val creator: CityBuilder = CityBuilder()
        var count: Int = 0
        while (true) {
            print("Введите ")
            print(creator.getField(count))
            print(": ")
            val value: String = try {
                ci.readNext()
            } catch (e: NoNextCommandException) {
                readln()
            }
            if (value != "") creator.setField(value, count)
            if (count == creator.size-1) break
            count++
        }
        try {
            creator.update(ci.cm.getElement(id))
            println("Элемент успешно обновлён")
        } catch (e: InvalidElementValueException) {
            println(e.message)
        }
    }

    override fun describe(): String {
        return "Обновляет значение элемента"
    }

    override fun getSyntax(): String {
        return "[id] {element}"
    }

    override fun getName(): String {
        return "update"
    }
}