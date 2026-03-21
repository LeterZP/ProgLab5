package commands

import core.CommandInvoker

/**
 * Команда для получения информации об элементах коллекции.
 *
 * @param ci [CommandInvoker], который вызывает команду.
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class ShowCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        val output: String = ci.cm.getAllElementsToString()
        if (output != "") println(output)
        else println("Коллекция пуста.")
    }

    override fun describe(): String {
        return "Выводит список всех элементов коллекции"
    }

    override fun getName(): String {
        return "show"
    }
}