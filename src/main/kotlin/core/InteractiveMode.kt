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
        } catch (e: CollectionHasNoElementException) {
            // логика
        } catch (e: CommandNotFoundException) {
            // логика
        } catch (e: InvalidAmountOfArgumentsException) {
            // логика
        } catch (e: InvalidElementValueException) {
            // логика
        } catch (e: Exception) {
            // логика
        }
    }

    fun start() {
        println("Программа запущена в интерактивном режиме. Чтобы увидеть список команд, введите help")
        interaction()
        println("Программа завершена. Спасибо за использование!")
    }


}