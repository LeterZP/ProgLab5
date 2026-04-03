package commands

import core.CollectionManager
import io.IOManager

/**
 * Команда для группировки по имени с подсчётом повторений.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @since 1.0
 */
class GroupCountingByNameCommand(io: IOManager, cm: CollectionManager): Command(io, cm) {
    override fun execute(token: List<String>) {
        super.execute(token)
        val names: HashMap<String, Int> = cm.groupElements()
        io.write("Названия городов:" + "\n")
        for (name in names) {
            io.write("  --" + name.key + ": " + name.value + "\n")
        }
    }

    override fun describe(): String {
        return "Выводит количество элементов, сгруппированных по названиям"
    }

    override fun getName(): String {
        return "group_counting_by_name"
    }
}