package exceptions

class CommandNotFoundException(private val command: String): Exception() {
    override val message: String = "Команда $command не найдена"
}