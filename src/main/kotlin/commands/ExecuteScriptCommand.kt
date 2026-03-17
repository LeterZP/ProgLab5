package commands

import core.CommandInvoker
import exceptions.NoNextCommandException
import io.ScriptReader

class ExecuteScriptCommand(ci: CommandInvoker): Command(ci) {
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
        val reader: ScriptReader = ScriptReader(ci)
        reader.startScript(token[0])
        try {
            while (true) {
                ci.readNext()
            }
        } catch (e: NoNextCommandException) {
            println(e.message)
        }
    }

    override fun describe(): String {
        return "Запускает команды из скрипта"
    }

    override fun getSyntax(): String {
        return "[file_name]"
    }

    override fun getName(): String {
        return "execute_script"
    }
}