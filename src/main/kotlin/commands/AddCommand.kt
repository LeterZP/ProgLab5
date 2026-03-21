package commands

import core.CommandInvoker
import elements.CityBuilder
import exceptions.InvalidElementValueException
import exceptions.NoNextCommandException

/**
 * Команда для добавления элемента в коллекцию.
 *
 * @param ci [CommandInvoker], который вызывает команду.
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class AddCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        val creator: CityBuilder = CityBuilder()
        var count: Int = 0
        while (true) {
            ci.printInCommandInvoker("Введите ")
            ci.printInCommandInvoker(creator.getField(count))
            ci.printInCommandInvoker(": ")
            val value: String = try { ci.readNext() } catch (e: NoNextCommandException) { readln() }
            try {
                creator.setField(value, count)
            } catch (e: InvalidElementValueException) {
                ci.printInCommandInvoker(e.message + "\n")
                continue
            }
            if (count == creator.size-1) break
            count++
        }
        try {
            ci.cm.addElement(creator.create())
            ci.printInCommandInvoker("Элемент успешно добавлен." + "\n")
        } catch (e: InvalidElementValueException) {
            ci.printInCommandInvoker(e.message + "\n")
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