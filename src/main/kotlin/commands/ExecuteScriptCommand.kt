package commands

import core.CommandInvoker
import io.ScriptReader

/**
 * Команда для исполнения скрипта.
 *
 * @param ci [CommandInvoker], который вызывает команду.
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class ExecuteScriptCommand(ci: CommandInvoker): Command(ci) {
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
        val reader: ScriptReader = ScriptReader(ci)
        reader.startScript(token[0])
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