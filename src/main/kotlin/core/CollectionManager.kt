package core

import elements.City
import elements.Climate
import elements.Government
import exceptions.CollectionHasNoElementException
import exceptions.InvalidElementValueException
import java.util.Stack
import java.time.LocalTime
import java.util.Locale
import java.util.Locale.getDefault

class CollectionManager() {
    val collection: Stack<City> = Stack<City>()
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

    inner class ElementCreator() {
        val creator: City.Companion.Creator = City.Companion.Creator()

        fun addValue(input: String, counter: Int) {
            var value: String?
            if (input == "") value = null
            else value = input
            try {
                when (counter) {
                    0 -> creator.name = value
                    1 -> creator.coordinateX = value?.toInt()
                    2 -> creator.coordinateY = value?.toDouble()
                    3 -> creator.area = value?.toDouble()
                    4 -> creator.population = value?.toInt()
                    5 -> creator.metersAboveSeaLevel = value?.toLong()
                    6 -> creator.populationDensity = value?.toFloat()
                    7 -> creator.govName = value
                    8 -> creator.govAge = value?.toLong()
                    9 -> creator.govHeight = value?.toFloat()
                    10 -> creator.climate = run {
                        value?.capitalize()
                        val result: Climate?
                        if (value != null) result = Climate.valueOf(value)
                        else result = null
                        result
                    }
                    11 -> creator.government = run {
                        value?.capitalize()
                        val result: Government?
                        if (value != null) result = Government.valueOf(value)
                        else result = null
                        result
                    }
                }
            } catch (e: NumberFormatException) {
                throw InvalidElementValueException(value?:"")
            } catch (e: IllegalArgumentException) {
                throw InvalidElementValueException(value?:"")
            }
            if (counter == 11) collection.push(creator.create())
        }
    }
}