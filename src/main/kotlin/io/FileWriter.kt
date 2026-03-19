package io

import elements.City
import java.io.BufferedWriter
import java.io.FileWriter
import java.util.Stack
import kotlinx.serialization.json.Json.Default.encodeToString

class FileWriter(file: String) {
    private val writer: BufferedWriter = BufferedWriter(FileWriter(file))

    fun writeToFile(collection: Stack<City>) {
        val collectionToEncode: List<City> = collection.toList()
        val text: String = encodeToString(collectionToEncode)
        writer.write(text)
        writer.close()
    }
}