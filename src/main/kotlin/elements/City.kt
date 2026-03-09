package elements

import exceptions.InvalidElementValueException
import java.time.LocalDate

class City(
    _name: String,
    _coordinates: Coordinates,
    _area: Double,
    _population: Int,
    _metersAboveSeaLevel: Long,
    _populationDensity: Float,
    _governon: Human,
    _climate: Climate? = null,
    _government: Government? = null
): Comparable<City> {

    var name: String = _name
        set(value) {
            if (value == "") throw InvalidElementValueException(value)
            field = value
        }
    var coordinates: Coordinates = _coordinates
    var area: Double = _area
        set(value) {
            if (value <= 0) throw InvalidElementValueException(value)
            field = value
        }
    var population: Int = _population
        set(value) {
            if (value <= 0) throw InvalidElementValueException(value)
            field = value
        }
    var metersAboveSeaLevel: Long = _metersAboveSeaLevel
    var populationDensity: Float = _populationDensity
        set(value) {
            if (value <= 0) throw InvalidElementValueException(value)
            field = value
        }
    var governon: Human = _governon
    var climate: Climate? = _climate
    var government: Government? = _government
    val id: Long = counter
    private val creationDate: LocalDate = LocalDate.now()

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

    companion object {
        private var counter: Long = 1

        class Creator() {
            private var name: String? = null
                set(value) {
                    if (value == null) throw InvalidElementValueException("")
                    field = value
                }
            private var coordinateX: Int? = null
                set(value) {
                    if (value is Int && value > -827) field = value
                    else throw InvalidElementValueException(value?: "")
                }
            private var coordinateY: Double? = null
                set(value) {
                    if (value == null) throw InvalidElementValueException("")
                    field = value
                }
            private var area: Double? = null
                set(value) {
                    if (value is Double && value > 0) field = value
                    else throw InvalidElementValueException(value?: "")
                }
            private var population: Int? = null
                set(value) {
                    if (value is Int && value > 0) field = value
                    else throw InvalidElementValueException(value?: "")
                }
            private var metersAboveSeaLevel: Long? = null
                set(value) {
                    if (value == null) throw InvalidElementValueException("")
                    field = value
                }
            private var populationDensity: Float? = null
                set(value) {
                    if (value is Float && value > 0) field = value
                    else throw InvalidElementValueException(value?: "")
                }
            private var govName: String? = null
                set(value) {
                    if (value == null) throw InvalidElementValueException("")
                    field = value
                }
            private var govAge: Long? = null
                set(value) {
                    if (value is Long && value > 0) field = value
                    else throw InvalidElementValueException(value?: "")
                }
            private var govHeight: Float? = null
                set(value) {
                    if (value is Float && value > 0) field = value
                    else throw InvalidElementValueException(value?: "")
                }
            private var climate: Climate? = null
            private var government: Government? = null
            val size = 12

            fun getField(count: Int): String? {
                when (count) {
                    0 -> return "название города (String)"
                    1 -> return "координата X (Int)"
                    2 -> return "координата Y (Double)"
                    3 -> return "площадь (Double)"
                    4 -> return "население (Int)"
                    5 -> return "высоту над уровнем моря (Long)"
                    6 -> return "плотность населения (Float)"
                    7 -> return "имя губернатора (String)"
                    8 -> return "возраст губернатора (Long)"
                    9 -> return "рост губернатора (Float)"
                    10 -> return "климат (RAIN_FOREST | MONSOON | HUMIDCONTINENTAL | SUBARCTIC | TUNDRA)"
                    11 -> return "правительство (ARISTOCRACY | ANARCHY | KLEPTOCRACY | CORPORATOCRACY | JUNTA)"
                }
                return null
            }

            fun setField(value: String?, count: Int) {
                when (count) {
                    0 -> name = value
                    1 -> coordinateX = value?.toInt()
                    2 -> coordinateY = value?.toDouble()
                    3 -> area = value?.toDouble()
                    4 -> population = value?.toInt()
                    5 -> metersAboveSeaLevel = value?.toLong()
                    6 -> populationDensity = value?.toFloat()
                    7 -> govName = value
                    8 -> govAge = value?.toLong()
                    9 -> govHeight = value?.toFloat()
                    10 -> climate = run {
                        val result: Climate? = if (value != null) Climate.valueOf(value.uppercase()) else null
                        result
                    }
                    11 -> government = run {
                        val result: Government? = if (value != null) Government.valueOf(value.uppercase()) else null
                        result
                    }
                }
            }

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
                    val cords = Coordinates(coordinateX!!, coordinateY!!)
                    val governon = Human(govName!!, govAge!!, govHeight!!)
                    return City(name!!, cords, area!!,
                        population!!, metersAboveSeaLevel!!, populationDensity!!,
                        governon, climate, government)
                } else throw InvalidElementValueException("City")
            }
        }
    }
}