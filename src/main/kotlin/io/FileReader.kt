package io

import elements.City
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.util.Stack
import kotlinx.serialization.json.Json.Default.decodeFromString

class FileReader(file: String) {
    private val input: FileInputStream = FileInputStream(file)
    private val reader: BufferedInputStream = BufferedInputStream(input)
    private val collection: Stack<City> = Stack<City>()

    fun readFile(): Stack<City> {
        val text: String = reader.readAllBytes().decodeToString()
        reader.close()
        if (text != "") {
            val decodedCollection: MutableList<City> = decodeFromString<MutableList<City>>(text)
            while (!decodedCollection.isEmpty()) {
                collection.push(decodedCollection[0])
                decodedCollection.removeAt(0)
            }
        }
        return collection
    }
}