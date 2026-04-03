package commands

import core.CollectionManager
import elements.CityBuilder
import exceptions.InvalidElementValueException
import io.IOManager

/**
 * Команда для обновления элемента коллекции.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class UpdateCommand(io: IOManager, cm: CollectionManager): Command(io, cm) {
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
        val id: Long
        try {
            id = token[0].toLong()
            val creator: CityBuilder = CityBuilder()
            var count: Int = 0
            while (true) {
                val value: String = io.askForValue(creator.getField(count))
                try {
                    if (value != "") creator.setField(value, count)
                    if (count == creator.size-1) break
                    count++
                } catch (_: InvalidElementValueException) {
                    io.write("Значение $value не может быть установлено. Повторите ввод.\n")
                }
            }
            creator.update(cm.getElement(id))
            io.write("Элемент успешно обновлён.\n")
        }
        catch (_: NumberFormatException) { io.write("${token[0]} не является id элемента.\n") }
        catch (e: InvalidElementValueException) { io.write(e.message + "\n") }
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