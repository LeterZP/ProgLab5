package commands

import core.CommandInvoker

class ClearCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        ci.cm.clearCollection()
    }

    override fun describe(): String {
        return "Удаляет все элементы коллекции"
    }

    override fun getName(): String {
        return "clear"
    }
}