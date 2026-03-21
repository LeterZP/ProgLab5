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
                print("Введите ")
                print(creator.getField(count))
                print(": ")
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
                    println("Значение $value не может быть установлено. Повторите ввод.")
                }
            }
            creator.update(ci.cm.getElement(id))
            println("Элемент успешно обновлён")
        }
        catch (_: NumberFormatException) { println("${token[0]} не является id элемента.") }
        catch (e: InvalidElementValueException) { println(e.message) }
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