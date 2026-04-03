package core

import commands.*
import exceptions.CommandNotFoundException
import exceptions.InvalidAmountOfArgumentsException
import exceptions.NoNextCommandException
import io.IOManager
import java.util.Stack

/**
 * Класс вызова команд.
 *
 * Позволяет вызывать инициализированные в нём команды для работы с коллекцией посредством [CollectionManager].
 *
 * @param io [IOManager], откуда читаются команды.
 * @param cm [CollectionManager], управляющий коллекцией.
 *
 * @property commands [HashMap] команд, содержащий имя команды типа [String] и саму команду типа [Command].
 *
 * @constructor Принимает все описанные выше параметры, создавая объект, уже содержащий в себе стандартный набор команд.
 *
 * @since 1.0
 */
class CommandInvoker(val io: IOManager, val cm: CollectionManager) {
    val commands: HashMap<String, Command> = HashMap()
    private val nextToken: Stack<String> = Stack<String>()

    init {
        initializeCommand(HelpCommand(io, cm, this))
        initializeCommand(InfoCommand(io, cm))
        initializeCommand(ShowCommand(io, cm))
        initializeCommand(AddCommand(io, cm))
        initializeCommand(UpdateCommand(io, cm))
        initializeCommand(RemoveByIdCommand(io, cm))
        initializeCommand(ClearCommand(io, cm))
        initializeCommand(SaveCommand(io, cm))
        initializeCommand(ExecuteScriptCommand(io, cm))
        initializeCommand(ExitCommand(io, cm))
        initializeCommand(RemoveLastCommand(io, cm))
        initializeCommand(RemoveGreaterCommand(io, cm))
        initializeCommand(ReorderCommand(io, cm))
        initializeCommand(GroupCountingByNameCommand(io, cm))
        initializeCommand(CountGreaterThenMetersAboveSeaLevelCommand(io, cm))
        initializeCommand(PrintFieldAscendingGovernmentCommand(io, cm))
    }

    /**
     * Инициализирует команду, добавляя её в список возможных к использованию.
     *
     * @param command Команда для инициализации, типа [Command].
     *
     * @since 1.0
     */
    fun initializeCommand(command: Command) {
        val name: String = command.getName()
        commands[name] = command
    }

    /**
     * Вызывает команду, читая её либо из очереди команд, либо из консоли в случае, если очередь пуста.
     *
     * @since 1.0
     */
    fun readCommand() {
        do {
            try {
                val instruction: List<String> = try {
                    readNext().split(" ")
                } catch (e: NoNextCommandException) {
                    io.read().split(" ")
                }
                if (instruction.size == 1 && instruction[0] == "") return
                commands.get(instruction[0])?.execute(instruction.minus(instruction[0]))
                    ?: throw CommandNotFoundException(instruction[0])
            } catch (e: CommandNotFoundException) {
                io.write(e.message + "\n")
            } catch (e: InvalidAmountOfArgumentsException) {
                io.write(e.message + "\n")
            }
        } while (!nextToken.isEmpty())
    }

    /**
     * Читает первую в очереди команду.
     *
     * @return Команду с аргументами типа [String].
     *
     * @throws NoNextCommandException В случае, если очередь из команд пуста.
     *
     * @since 1.0
     */
    fun readNext(): String {
        val result: String
        if (nextToken.isEmpty()) throw NoNextCommandException()
        else {
            result = nextToken.pop()
        }
        return result
    }

    /**
     * Добавляет одну или несколько команд в очередь.
     *
     * @param instructions Одна или несколько команд с аргументами типа [String].
     *
     * @since 1.0
     */
    fun addNext(instructions: String) {
        val values: List<String> = instructions.lines().reversed()
        for (instruction in values) {
            nextToken.push(instruction)
        }
    }
}