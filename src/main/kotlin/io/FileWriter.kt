package io

import elements.City
import java.io.BufferedWriter
import java.io.FileWriter
import java.util.Stack
import kotlinx.serialization.json.Json.Default.encodeToString

/**
 * Класс для записи в файл.
 *
 * @param file Имя файла типа [String].
 *
 * @constructor Создаёт готовый к использованию объект с использованием всех упомянутых выше параметров.
 *
 * @since 1.0
 */
class FileWriter(file: String) {
    private val writer: BufferedWriter = BufferedWriter(FileWriter(file))

    /**
     * Записывает [Stack] с элементами [City] в указанный в конструкторе [FileWriter][io.FileWriter] файл.
     *
     * @param collection [Stack] элементов типа [City].
     *
     * @throws [java.io.IOException] В случае ошибки записи в файл.
     */
    fun writeToFile(collection: Stack<City>) {
        val collectionToEncode: List<City> = collection.toList()
        val text: String = encodeToString(collectionToEncode)
        writer.write(text)
        writer.close()
    }
}