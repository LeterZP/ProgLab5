package commands

import core.CollectionManager
import elements.Government
import io.IOManager

/**
 * Команда для получения всех свойств вида [Government] в сортированном виде.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class PrintFieldAscendingGovernmentCommand(io: IOManager, cm: CollectionManager): Command(io, cm) {
    override fun execute(token: List<String>) {
        super.execute(token)
        val governments: MutableList<Government?> = cm.getSortedGovernments()
        for (element in governments) {
            io.write(element.toString() + "\n")
        }
    }

    override fun describe(): String {
        return "Выводит правительства городов в порядке возрастания"
    }

    override fun getName(): String {
        return "print_field_ascending_government"
    }
}