package commands

import core.CommandInvoker

/**
 * Команда для очистки коллекции.
 *
 * @param ci [CommandInvoker], который вызывает команду.
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class ClearCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        ci.cm.clearCollection()
        println("Коллекция отчищена.")
    }

    override fun describe(): String {
        return "Удаляет все элементы коллекции"
    }

    override fun getName(): String {
        return "clear"
    }
}