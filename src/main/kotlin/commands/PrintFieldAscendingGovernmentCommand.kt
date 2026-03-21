package commands

import core.CommandInvoker
import elements.Government

/**
 * Команда для получения всех свойств вида [Government] в сортированном виде.
 *
 * @param ci [CommandInvoker], который вызывает команду.
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class PrintFieldAscendingGovernmentCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        val governments: ArrayList<Government> = ci.cm.getSortedGovernments()
        for (element in governments) {
            println(element)
        }
    }

    override fun describe(): String {
        return "Выводит правительства городов в порядке возрастания"
    }

    override fun getName(): String {
        return "print_field_ascending_government"
    }
}