package elements

import exceptions.InvalidElementValueException

class Human(private val name: String, private val age: Long, private val height: Float) {
    init{
        if (name == "") throw InvalidElementValueException(name)
        if (age <= 0) throw InvalidElementValueException(age)
        if (height <= 0) throw InvalidElementValueException(height)
    }
}