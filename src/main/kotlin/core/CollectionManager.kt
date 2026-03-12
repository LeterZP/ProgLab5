package core

import elements.City
import exceptions.CollectionHasNoElementException
import exceptions.InvalidElementValueException
import java.util.Stack
import java.time.LocalTime

class CollectionManager() {
    val collection: Stack<City> = Stack<City>()
    val initializationTime: LocalTime = LocalTime.now()

    fun sortElements() {
        collection.sort()
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

    fun clearCollection() { collection.clear() }

    fun getSize(): Int {
        return collection.size
    }

    inner class ElementCreator() {
        val creator: City.Companion.Creator = City.Companion.Creator()

        fun addValue(input: String, count: Int) {
            val value: String? = if (input == "") null
            else input
            try {
                creator.setField(value, count)
            } catch (_: NumberFormatException) {
                throw InvalidElementValueException(value?:"")
            } catch (_: IllegalArgumentException) {
                throw InvalidElementValueException(value?:"")
            }
            if (count == creator.size-1) collection.push(creator.create())
            sortElements()
        }
    }
}