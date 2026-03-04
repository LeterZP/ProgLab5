package exceptions

class CollectionHasNoElement(id: Long): Exception() {
    override val message: String = "Collection doesn't have an element with id $id"
}