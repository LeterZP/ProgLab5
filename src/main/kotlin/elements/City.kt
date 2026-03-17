package elements

import exceptions.InvalidElementValueException
import java.time.LocalDate

class City(
    name: String,
    var coordinates: Coordinates,
    area: Double,
    population: Int,
    var metersAboveSeaLevel: Long,
    populationDensity: Float,
    var governon: Human,
    var climate: Climate? = null,
    var government: Government? = null
): Comparable<City> {

    var name: String = name
        set(value) {
            if (value == "") throw InvalidElementValueException(value)
            field = value
        }
    var area: Double = area
        set(value) {
            if (value <= 0) throw InvalidElementValueException(value)
            field = value
        }
    var population: Int = population
        set(value) {
            if (value <= 0) throw InvalidElementValueException(value)
            field = value
        }
    var populationDensity: Float = populationDensity
        set(value) {
            if (value <= 0) throw InvalidElementValueException(value)
            field = value
        }
    val id: Long = counter
    val creationDate: LocalDate = LocalDate.now()

    companion object { private var counter: Long = 1 }

    init{ counter++ }

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

    override fun toString(): String {
        var output: String = """
           --$id: Город $name 
                был создан $creationDate
                расположен по координатам $coordinates 
                $metersAboveSeaLevel метров над уровнем моря
                занимает площадь $area
                с населением $population и его плотностью $populationDensity
                управляет им $governon
        """.trimIndent()
        if (government != null) {
            output += "\n     с правительством $government"
        }
        if (climate != null) {
            output += "\n     да и погода там $climate"
        }
        return output
    }
}