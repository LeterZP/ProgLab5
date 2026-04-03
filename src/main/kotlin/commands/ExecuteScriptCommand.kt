package commands

import core.CollectionManager
import io.IOManager

/**
 * Команда для исполнения скрипта.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class ExecuteScriptCommand(io: IOManager, cm: CollectionManager): Command(io, cm) {
    override val tokenAmount: Int = 1

    override fun execute(token: List<String>) {
        super.execute(token)
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