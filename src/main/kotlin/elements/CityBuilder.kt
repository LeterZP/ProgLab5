package elements

import exceptions.InvalidElementValueException

/**
 * Builder для класса [City].
 *
 * Модет поэтапно создавать и изменять объекты класса [City].
 * @property name [City.name].
 * @property coordinateX [Coordinates.x].
 * @property coordinateY [Coordinates.y].
 * @property area [City.area].
 * @property population [City.population].
 * @property metersAboveSeaLevel
 * @property populationDensity
 * @property govName
 * @property govAge
 * @property govHeight
 * @property climate
 * @property government
 * @property fields
 * @property size
 */
class CityBuilder {
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
    private val fields: Array<String> = arrayOf(
        "название города (String)",
        "координата X (Int)",
        "координата Y (Double)",
        "площадь (Double)",
        "население (Int)",
        "высоту над уровнем моря (Long)",
        "плотность населения (Float)",
        "имя губернатора (String)",
        "возраст губернатора (Long)",
        "рост губернатора (Float)",
        "климат (RAIN_FOREST | MONSOON | HUMIDCONTINENTAL | SUBARCTIC | TUNDRA)",
        "правительство (ARISTOCRACY | ANARCHY | KLEPTOCRACY | CORPORATOCRACY | JUNTA)"
    )
    val size = 12

    fun getField(count: Int): String {
        return fields[count]
    }

    fun setField(input: String, count: Int) {
        val value: String? = if (input == "") null else input
        try {
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
        } catch (_: NumberFormatException) {
            throw InvalidElementValueException(value?:"")
        } catch (_: IllegalArgumentException) {
            throw InvalidElementValueException(value?:"")
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

    fun update(city: City) {
        if (name != null) city.name = name!!
        if (coordinateX != null && coordinateY != null)
            city.coordinates = Coordinates(coordinateX!!, coordinateY!!)
        if (area != null) city.area = area!!
        if (population != null) city.population = population!!
        if (metersAboveSeaLevel != null) city.metersAboveSeaLevel = metersAboveSeaLevel!!
        if (populationDensity != null) city.populationDensity = populationDensity!!
        if (govName != null && govAge != null && govHeight != null)
            city.governon = Human(govName!!, govAge!!, govHeight!!)
        if (climate != null) city.climate = climate
        if (government != null) city.government = government
    }
}