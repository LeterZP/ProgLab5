package exceptions

class CollectionHasNoElementException(private val id: Long): Exception() {
    override val message: String = "Collection doesn't have an element with id $id"
}