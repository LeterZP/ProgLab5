package commands

import core.CommandInvoker
import exceptions.InvalidAmountOfArgumentsException

abstract class Command(protected val ci: CommandInvoker) {
    open val tokenAmount: Int = 0

    override fun toString(): String {
        if (getSyntax() == "") return getName() + getSyntax()
        return getName() + " " + getSyntax()
    }

    open fun execute(token: List<String>) {
        while (token.contains("")) token.minus("")
        if (token.size != tokenAmount) throw InvalidAmountOfArgumentsException(this, token.size)
    }

    open fun describe(): String {
        return "У этой команды нет описания"
    }

    open fun getSyntax(): String {
        return ""
    }

    open fun getName(): String {
        return "command"
    }
}