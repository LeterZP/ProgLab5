package core

import exceptions.*

class InteractiveMode(private val cm: CollectionManager) {
    private val ci: CommandInvoker = CommandInvoker(cm)

    private fun interaction() {
        try {
            while (true) {
                print("=> ")
                ci.readCommand()
            }
        } catch (e: ProgramExitException) {
            println(e.message)
            return
        } catch (e: Exception) {
            println("Возникла неизвестная ошибка: " + e.message)
            println("Экстренное завершение работы")
        }
    }

    fun start() {
        println("Программа запущена в интерактивном режиме. Чтобы увидеть список команд, введите help")
        interaction()
    }
}