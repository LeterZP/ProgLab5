package commands

import core.CollectionManager
import io.IOManager

/**
 * Команда для получения информации о коллекции.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class InfoCommand(io: IOManager, cm: CollectionManager): Command(io, cm) {
    override fun describe(): String {
        return "Выводит всю информацию о коллекции"
    }

    override fun execute(token: List<String>) {
        super.execute(token)
        val time = cm.initializationTime
        val size = cm.size()
        io.write("Информация о коллекции:" + "\n")
        io.write("  --Тип коллекции: java.util.Stack" + "\n")
        io.write("  --Дата инициализации коллекции: $time\n")
        io.write("  --Количество элементов в коллекции: $size\n")
    }

    override fun getName(): String {
        return "info"
    }
}