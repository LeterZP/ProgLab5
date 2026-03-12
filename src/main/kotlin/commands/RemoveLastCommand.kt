package commands

import core.CommandInvoker

class RemoveLastCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        ci.cm.removeLast()
    }

    override fun describe(): String {
        return "Удаляет последний элемент коллекции"
    }

    override fun getName(): String {
        return "remove_last"
    }
}