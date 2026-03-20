package io

import elements.City
import java.io.BufferedInputStream
import java.io.FileInputStream
import java.util.Stack
import kotlinx.serialization.json.Json.Default.decodeFromString

/**
 * Класс для чтения файла.
 *
 * @param file Имя файла типа [String].
 *
 * @constructor Принимает все описанные выше параметры, создавая готовый к использованию объект.
 *
 * @since 1.0
 */
class FileReader(file: String) {
    private val input: FileInputStream = FileInputStream(file)
    private val reader: BufferedInputStream = BufferedInputStream(input)
    private val collection: Stack<City> = Stack<City>()

    /**
     * Читает информацию из переданного в конструктор [FileReader][io.FileReader] файла.
     *
     * @return [Stack], заполненный [City].
     *
     * @throws [java.io.IOException] В случае ошибки чтения файла.
     * @throws [OutOfMemoryError] В случае, если файл слишком большой.
     * @throws [kotlinx.serialization.SerializationException] Если возникла ошибка при десериализации файла.
     * @throws [IllegalArgumentException] Если невозможно преобразовать полученные из файла данные в [Stack].
     *
     * @since 1.0
     */
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