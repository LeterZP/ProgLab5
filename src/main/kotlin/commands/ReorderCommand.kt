package commands

import core.CommandInvoker

/**
 * Команда для переворота коллекции.
 *
 * @param ci [CommandInvoker], который вызывает команду.
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class ReorderCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        ci.cm.reorderElements()
        ci.printInCommandInvoker("Коллекция успешно перевёрнута.\n")
    }

    override fun describe(): String {
        return "Переворачивает коллекцию"
    }

    override fun getName(): String {
        return "reorder"
    }
}