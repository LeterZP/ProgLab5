package exceptions

class InvalidElementValueException(value: Any): Exception() {
    override val message: String = "Collection element has value $value that can't be initialized"
}