package commands

import core.CommandInvoker
import exceptions.InvalidElementValueException

class CountGreaterThenMetersAboveSeaLevelCommand(ci: CommandInvoker): Command(ci) {
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
        try {
            println("Количество: " + ci.cm.countHigherThen(token[0].toLong()))
        } catch (e: NumberFormatException) {
            throw InvalidElementValueException(token[0])
        }
    }

    override fun describe(): String {
        return "Выводит количество элементов выше заданного уровня моря"
    }

    override fun getSyntax(): String {
        return "[metersAboveSeaLevel]"
    }

    override fun getName(): String {
        return "count_greater_then_meters_above_sea_level"
    }
}