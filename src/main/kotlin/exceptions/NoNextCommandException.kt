package exceptions

class NoNextCommandException: Exception() {
    override val message: String = "Чтение скрипта оконченно"
}