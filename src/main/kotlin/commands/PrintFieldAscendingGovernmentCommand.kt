package commands

import core.CommandInvoker
import elements.Government

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