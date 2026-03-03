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
) {
    companion object { private var counter: Long = 1}

    private val id: Long = counter
    private val creationDate: LocalDate = LocalDate.now()

    init{
        if (name == "") throw InvalidElementValueException(name)
        if (area <= 0) throw InvalidElementValueException(area)
        if (population <= 0) throw InvalidElementValueException(population)
        if (populationDensity <= 0) throw InvalidElementValueException(populationDensity)
        counter++
    }
}