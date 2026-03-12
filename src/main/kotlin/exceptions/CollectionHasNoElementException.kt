package exceptions

class CollectionHasNoElementException(private val id: Long): Exception() {
    override val message: String = "У коллекции нет элемента с id $id"
}