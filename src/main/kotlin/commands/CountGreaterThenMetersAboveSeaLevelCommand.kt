package commands

import core.CommandInvoker

/**
 * Команда для вывода количества элементов коллекции, высота над уровнем моря которых больше заданного.
 *
 * @param ci [CommandInvoker], который вызывает команду.
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class CountGreaterThenMetersAboveSeaLevelCommand(ci: CommandInvoker): Command(ci) {
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
        try {
            println("Количество: " + ci.cm.countHigherThen(token[0].toLong()))
        } catch (e: NumberFormatException) {
            println("Невозможно сравнить с данным значением, оно должно быть типа Long.")
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