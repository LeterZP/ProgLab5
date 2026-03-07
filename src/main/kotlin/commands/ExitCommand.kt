package commands

import core.CommandInvoker
import exceptions.ProgramExitException

class ExitCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        throw ProgramExitException()
    }

    override fun describe(): String {
        return "Завершает работу программы"
    }

    override fun getName(): String {
        return "exit"
    }
}