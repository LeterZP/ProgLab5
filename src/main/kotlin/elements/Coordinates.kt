package elements

import exceptions.InvalidElementValueException

class Coordinates(private val x: Int, private val y: Double) {
    init{
        if(x <= -827) throw InvalidElementValueException(x)
    }

    override fun toString(): String {
        return "x = $x, y = $y"
    }
}