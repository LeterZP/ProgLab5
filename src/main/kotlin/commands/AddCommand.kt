package commands

import core.CommandInvoker
import core.CollectionManager
import exceptions.InvalidElementValueException

class AddCommand(ci: CommandInvoker): Command(ci) {
    override fun execute(token: List<String>) {
        super.execute(token)
        input()
    }

    override fun getSyntax(): String {
        return """
        [String]
        [Integer]
        [Double]
        [Double]
        [Integer]
        [Long]
        [Float]
        [String]
        [Long]
        [Float]
        [<null> | String]
        [<null> | String]
        """
    }

    override fun getName(): String {
        return "add"
    }

    override fun describe(): String {
        return "Добавляет элемент в коллекцию"
    }

    fun input() {
        val creator: CollectionManager.ElementCreator = ci.cm.ElementCreator()
        var counter: Int = 0
        while (true) {
            print("Введите ")
            when (counter) {
                0 -> print("название города: ")
                1 -> print("координату X: ")
                2 -> print("координату Y: ")
                3 -> print("площадь: ")
                4 -> print("население: ")
                5 -> print("высоту над уровнем моря: ")
                6 -> print("плотность населения: ")
                7 -> print("имя губернатора: ")
                8 -> print("возраст губернатора: ")
                9 -> print("рост губернатора: ")
                10 -> print("климат: ")
                11 -> print("правительство: ")
            }
            val value: String = readln()
            try {
                creator.addValue(value, counter)
            } catch (e: InvalidElementValueException) {
                println(e.message)
                continue
            }
            if (counter == 11) break
            counter++
        }
        println("Элемент успешно добавлен")
    }
}