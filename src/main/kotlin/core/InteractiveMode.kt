package core

import exceptions.*

/**
 * Класс интерактивного взаимодействия с программой.
 *
 * Позволяет консольно взаимодействовать с программой и вводить команды через консоль.
 *
 * @param cm [CollectionManager], содержащий коллекцию элементов [City][elements.City], с которой будут взаимодействовать команды.
 *
 * @constructor Принимает все описанные выше параметры.
 *
 * @since 1.0
 */
class InteractiveMode(private val cm: CollectionManager) {
    private val ci: CommandInvoker = CommandInvoker(cm)

    /**
     * Запускает взаимодействие с программой.
     *
     * @since 1.0
     */
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
            println("Возникла непредвиденная ошибка: " + e.message)
            println("Экстренное завершение работы")
        }
    }

    /**
     * Запускает интерактивный режим.
     *
     * @since 1.0
     */
    fun start() {
        println("Программа запущена в интерактивном режиме. Чтобы увидеть список команд, введите help")
        interaction()
    }
}