package core

import elements.City
import elements.Government
import exceptions.CollectionHasNoElementException
import java.util.Stack
import java.time.LocalTime

class CollectionManager() {
    private var collection: Stack<City> = Stack<City>()
    val initializationTime: LocalTime = LocalTime.now()
    val size: Int = collection.size

    fun sortElements() {
        collection.sort()
    }

    fun addElement(city: City) {
        collection.push(city)
        sortElements()
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

    fun getAllElementsToString(): String {
        var result: String = ""
        for (element in collection) {
            if (result != "") result += "\n"
            result += element.toString()
        }
        return result
    }

    fun getSortedGovernments(): ArrayList<Government> {
        val governments: ArrayList<Government> = ArrayList()
        collection.sortWith(Comparator { city1, city2 -> compareValues(city1.government, city2.government) })
        for (element in collection) {
            governments.plus(element.government)
        }
        sortElements()
        return governments
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

    fun removeGreater(id: Long) {
        collection.sort()
        while (true) {
            val element: City = collection.peek()
            if (element.id <= id) return
            collection.pop()
        }
    }

    fun clearCollection() { collection.clear() }
}