package exceptions

class CommandNotFoundException(command: String): Exception() {
    override val message: String = "Команда $command не найдена"
}