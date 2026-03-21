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
                ci.printInCommandInvoker("=> ")
                ci.readCommand()
            }
        } catch (e: ProgramExitException) {
            ci.printInCommandInvoker(e.message + "\n")
            return
        } catch (e: Exception) {
            ci.printInCommandInvoker("Возникла непредвиденная ошибка: " + e.message + "\n")
            ci.printInCommandInvoker("Экстренное завершение работы.\n")
        }
    }

    /**
     * Запускает интерактивный режим.
     *
     * @since 1.0
     */
    fun start() {
        ci.printInCommandInvoker("Программа запущена в интерактивном режиме. Чтобы увидеть список команд, введите help.\n")
        interaction()
    }
}