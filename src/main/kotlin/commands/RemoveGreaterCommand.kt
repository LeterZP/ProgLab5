package commands

import core.CommandInvoker

class RemoveGreaterCommand(ci: CommandInvoker): Command(ci){
    override fun execute(token: List<String>) {
        super.execute(token)
        input()
    }

    override fun describe(): String {
        return super.describe()
    }

    override fun getSyntax(): String {
        return "{element}"
    }

    override fun getName(): String {
        return "remove_greater"
    }

    fun input() {
        // логика
    }
}