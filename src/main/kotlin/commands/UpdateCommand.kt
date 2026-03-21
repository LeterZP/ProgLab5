package commands

import core.CommandInvoker
import elements.CityBuilder
import exceptions.InvalidElementValueException
import exceptions.NoNextCommandException

/**
 * Команда для обновления элемента коллекции.
 *
 * @param ci [CommandInvoker], который вызывает команду.
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class UpdateCommand(ci: CommandInvoker): Command(ci) {
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
        val id: Long
        try {
            id = token[0].toLong()
            val creator: CityBuilder = CityBuilder()
            var count: Int = 0
            while (true) {
                ci.printInCommandInvoker("Введите ")
                ci.printInCommandInvoker(creator.getField(count))
                ci.printInCommandInvoker(": ")
                val value: String = try {
                    ci.readNext()
                } catch (_: NoNextCommandException) {
                    readln()
                }
                try {
                    if (value != "") creator.setField(value, count)
                    if (count == creator.size-1) break
                    count++
                } catch (_: InvalidElementValueException) {
                    ci.printInCommandInvoker("Значение $value не может быть установлено. Повторите ввод.\n")
                }
            }
            creator.update(ci.cm.getElement(id))
            ci.printInCommandInvoker("Элемент успешно обновлён.\n")
        }
        catch (_: NumberFormatException) { ci.printInCommandInvoker("${token[0]} не является id элемента.\n") }
        catch (e: InvalidElementValueException) { ci.printInCommandInvoker(e.message + "\n") }
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