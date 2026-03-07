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
    private var governon: Human,
    private var climate: Climate? = null,
    private var government: Government? = null
): Comparable<City> {

    val id: Long = counter
    private val creationDate: LocalDate = LocalDate.now()

    init{
        checkValues(name, area, population, populationDensity)
        counter++
    }

    private fun checkValues(name: String,
                            area: Double,
                            population: Int,
                            populationDensity: Float
    ) {
        if (name == "") throw InvalidElementValueException(name)
        if (area <= 0) throw InvalidElementValueException(area)
        if (population <= 0) throw InvalidElementValueException(population)
        if (populationDensity <= 0) throw InvalidElementValueException(populationDensity)
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
            output += "методом $government"
        }
        if (climate != null) {
            output += "да и погода там $climate"
        }
        return output
    }

    companion object {
        private var counter: Long = 1

        class Creator() {
            var name: String? = null
                set(value) {
                    if (value == null) throw InvalidElementValueException("")
                    field = value
                }
            var coordinateX: Int? = null
                set(value) {
                    if (value is Int && value > -827) field = value
                    else throw InvalidElementValueException(value?: "")
                }
            var coordinateY: Double? = null
                set(value) {
                    if (value == null) throw InvalidElementValueException("")
                    field = value
                }
            var area: Double? = null
                set(value) {
                    if (value is Double && value > 0) field = value
                    else throw InvalidElementValueException(value?: "")
                }
            var population: Int? = null
                set(value) {
                    if (value is Int && value > 0) field = value
                    else throw InvalidElementValueException(value?: "")
                }
            var metersAboveSeaLevel: Long? = null
                set(value) {
                    if (value == null) throw InvalidElementValueException("")
                    field = value
                }
            var populationDensity: Float? = null
                set(value) {
                    if (value is Float && value > 0) field = value
                    else throw InvalidElementValueException(value?: "")
                }
            var govName: String? = null
                set(value) {
                    if (value == null) throw InvalidElementValueException("")
                    field = value
                }
            var govAge: Long? = null
                set(value) {
                    if (value is Long && value > 0) field = value
                    else throw InvalidElementValueException(value?: "")
                }
            var govHeight: Float? = null
                set(value) {
                    if (value is Float && value > 0) field = value
                    else throw InvalidElementValueException(value?: "")
                }
            var climate: Climate? = null
            var government: Government? = null

            fun create(): City {
                if (name != null
                    && coordinateX != null
                    && coordinateY != null
                    && area != null
                    && population != null
                    && metersAboveSeaLevel != null
                    && populationDensity != null
                    && govName != null
                    && govAge != null
                    && govHeight != null
                ) {
                    val cords: Coordinates = Coordinates(coordinateX!!, coordinateY!!)
                    val governon: Human = Human(govName!!, govAge!!, govHeight!!)
                    return City(name!!, cords, area!!,
                        population!!, metersAboveSeaLevel!!, populationDensity!!,
                        governon, climate, government)
                } else throw InvalidElementValueException("City")
            }
        }
    }
}