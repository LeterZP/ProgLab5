package exceptions

class InvalidElementValueException(private val value: Any): Exception() {
    override val message: String = "Значение '$value' не может быть задано"
}