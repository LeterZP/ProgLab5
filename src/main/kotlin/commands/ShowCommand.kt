package commands

import core.CommandInvoker

class ShowCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        println(ci.cm.getAllElementsToString())
    }

    override fun describe(): String {
        return "Выводит список всех элементов коллекции"
    }

    override fun getName(): String {
        return "show"
    }
}