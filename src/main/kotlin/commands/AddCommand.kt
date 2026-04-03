package commands

import core.CollectionManager
import io.IOManager
import elements.CityBuilder
import exceptions.InvalidElementValueException

/**
 * Команда для добавления элемента в коллекцию.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class AddCommand(io: IOManager, cm: CollectionManager): Command(io, cm) {
    override fun execute(token: List<String>) {
        super.execute(token)
        val creator: CityBuilder = CityBuilder()
        var count: Int = 0
        while (true) {
            val value: String = io.askForValue(creator.getField(count))
            try {
                creator.setField(value, count)
            } catch (e: InvalidElementValueException) {
                io.write(e.message + "\n")
                continue
            }
            if (count == creator.size-1) break
            count++
        }
        try {
            cm.addElement(creator.create())
            io.write("Элемент успешно добавлен." + "\n")
        } catch (e: InvalidElementValueException) {
            io.write(e.message + "\n")
        }
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
}