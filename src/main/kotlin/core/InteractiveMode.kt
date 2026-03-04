package core

class InteractiveMode(private val cm: CollectionManager) {
    private val ci: CommandInvoker = CommandInvoker(cm)

    fun work() {
        println("Программа запущена в интерактивном режиме. Чтобы увидеть список команд, введите help")
        ci.readCommand()
    }
}