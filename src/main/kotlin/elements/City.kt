package elements

import exceptions.InvalidElementValueException
import java.time.LocalDate

class City(
    private var name: String,
    private var coordinates: Coordinates,
    private var area: Double,
    private var population: Int,
    private var metersAboveSeaLevel: Long,
    private var populationDensity: Float,
    private var governon: Human?,
    private var climate: Climate? = null,
    private var government: Government? = null
): Comparable<City> {
    private companion object { private var counter: Long = 1}

    val id: Long = counter
    private val creationDate: LocalDate = LocalDate.now()

    init{
        checkValues(name, area, population, populationDensity)
        counter++
    }

    private fun checkValues(name: String? = null,
                            area: Double? = null,
                            population: Int? = null,
                            populationDensity: Float? = null
    ) {
        if (name != null && name == "") throw InvalidElementValueException(name)
        if (area != null && area <= 0) throw InvalidElementValueException(area)
        if (population != null && population <= 0) throw InvalidElementValueException(population)
        if (populationDensity != null && populationDensity <= 0) throw InvalidElementValueException(populationDensity)
    }

    override fun compareTo(other: City): Int {
        return this.id.compareTo(other.id)
    }

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other is City) {
            if (this.id == other.id) return true
        }
        return false
    }
}