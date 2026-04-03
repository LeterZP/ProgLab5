package commands

import core.CollectionManager
import exceptions.ProgramExitException
import io.IOManager

/**
 * Команда для выхода из программы.
 *
 * @param io [IOManager] для [Command].
 * @param cm [CollectionManager] для [Command].
 *
 * @constructor Вызывает родительский конструктор класса [Command].
 *
 * @throws ProgramExitException В качестве сигнала завершения программы.
 *
 * @since 1.0
 */
class ExitCommand(io: IOManager, cm: CollectionManager): Command(io, cm) {
    override fun execute(token: List<String>) {
        super.execute(token)
        throw ProgramExitException()
    }

    override fun describe(): String {
        return "Завершает работу программы"
    }

    override fun getName(): String {
        return "exit"
    }
}