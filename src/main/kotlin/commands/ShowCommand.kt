package commands

import core.CommandInvoker

class ShowCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        val output: String = ci.cm.getAllElementsToString()
        if (output != "") println(output)
        else println("Коллекция пуста.")
    }

    override fun describe(): String {
        return "Выводит список всех элементов коллекции"
    }

    override fun getName(): String {
        return "show"
    }
}