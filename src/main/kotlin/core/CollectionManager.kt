package core

import elements.City
import exceptions.CollectionHasNoElement
import java.util.Stack

class CollectionManager {
    private val collection: Stack<City> = Stack<City>()

    fun sortElements() {
        collection.sort()
    }

    fun addElement(element: City) {
        collection.push(element)
    }

    fun getElement(id: Long): City {
        if (collection.empty()) throw CollectionHasNoElement(id)
        var element: City? = null
        for (e in collection) {
            if (e.id == id) element = e
        }
        return element?: throw CollectionHasNoElement(id)
    }

    fun removeElement(id: Long) {
        if (!collection.remove(this.getElement(id))) throw CollectionHasNoElement(id)
    }
}