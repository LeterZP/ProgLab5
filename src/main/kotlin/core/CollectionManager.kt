package core

import elements.City
import exceptions.CollectionHasNoElementException
import exceptions.InvalidElementValueException
import java.util.Stack
import java.time.LocalTime

class CollectionManager() {
    var collection: Stack<City> = Stack<City>()
    val initializationTime: LocalTime = LocalTime.now()
    val size: Int = collection.size

    fun sortElements() {
        collection.sort()
    }

    fun reorderElements() {
        val newCollection: Stack<City> = Stack<City>()
        while (!collection.isEmpty()) {
            newCollection.push(collection.pop())
        }
        collection = newCollection
    }

    fun countHigherThen(metersAboveSeaLevel: Long): Int {
        var count: Int = 0
        for (element in collection) {
            if (element.metersAboveSeaLevel > metersAboveSeaLevel) {
                count++
            }
        }
        return count
    }

    fun getElement(id: Long): City {
        if (collection.empty()) throw CollectionHasNoElementException(id)
        var element: City? = null
        for (e in collection) {
            if (e.id == id) element = e
        }
        return element?: throw CollectionHasNoElementException(id)
    }

    fun groupElements(): HashMap<String, Int> {
        val names: HashMap<String, Int> = HashMap()
        for (element in collection) {
            names[element.name] = names[element.name] ?: 0
            names[element.name] = names[element.name]!! + 1
        }
        return names
    }

    fun removeElement(id: Long) {
        if (!collection.remove(this.getElement(id))) throw CollectionHasNoElementException(id)
    }

    fun removeLast() {
        if (collection.empty()) throw CollectionHasNoElementException(-1)
        collection.remove(collection.last())
    }

    fun removeGreater(city: City) {
        collection.sort()
        while (true) {
            val element: City = collection.peek()
            if (element <= city) return
            collection.pop()
        }
    }

    fun clearCollection() { collection.clear() }

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