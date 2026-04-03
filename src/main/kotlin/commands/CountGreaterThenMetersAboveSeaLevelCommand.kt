package commands

import core.CollectionManager
import io.IOManager

/**
 * Команда для вывода количества элементов коллекции, высота над уровнем моря которых больше заданного.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class CountGreaterThenMetersAboveSeaLevelCommand(io: IOManager, cm: CollectionManager): Command(io, cm) {
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
        try {
            io.write("Количество: "
                    + cm.countHigherThen(token[0].toLong()) + "\n")
        } catch (e: NumberFormatException) {
            io.write("Невозможно сравнить с данным значением, оно должно быть типа Long." + "\n")
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