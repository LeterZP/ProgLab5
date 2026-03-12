package commands

import core.CommandInvoker

class ReorderCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        ci.cm.reorderElements()
    }

    override fun describe(): String {
        return "Переворачивает коллекцию"
    }

    override fun getName(): String {
        return "reorder"
    }
}