package core

import elements.City
import exceptions.CollectionHasNoElementException
import java.util.Stack
import java.time.LocalTime

class CollectionManager() {
    private val collection: Stack<City> = Stack<City>()
    val initializationTime: LocalTime = LocalTime.now()

    fun sortElements() {
        collection.sort()
    }

    fun addElement(element: City) {
        collection.push(element)
        sortElements()
    }

    fun getElement(id: Long): City {
        if (collection.empty()) throw CollectionHasNoElementException(id)
        var element: City? = null
        for (e in collection) {
            if (e.id == id) element = e
        }
        return element?: throw CollectionHasNoElementException(id)
    }

    fun removeElement(id: Long) {
        if (!collection.remove(this.getElement(id))) throw CollectionHasNoElementException(id)
    }

    fun getSize(): Int {
        return collection.size
    }
}