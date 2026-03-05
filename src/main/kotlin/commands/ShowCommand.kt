package commands

import core.CommandInvoker

class ShowCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        for (element in ci.cm.collection) {
            println(element.toString())
        }
    }

    override fun describe(): String {
        return "Выводит список всех элементов коллекции"
    }

    override fun getName(): String {
        return "show"
    }
}