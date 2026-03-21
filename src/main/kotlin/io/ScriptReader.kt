package io

import core.CommandInvoker
import java.io.File
import java.io.FileNotFoundException

/**
 * Класс для чтения команд из скрипта.
 *
 * @param ci Объект типа [CommandInvoker], который будет вызывать команды скрипта.
 *
 * @constructor Создаёт готовый к использованию объект, принимая все описанные выше параметры.
 *
 * @since 1.0
 */
class ScriptReader(val ci: CommandInvoker) {
    /**
     * Добавляет команды из скрипта в очередь на выполнение в классе [CommandInvoker].
     *
     * @param file Имя файла типа [String].
     *
     * @since 1.0
     */
    fun startScript(file: String) {
        try {
            val commands: String = File(file).readText()
            ci.addNext(commands)
        } catch (e: FileNotFoundException) {
            ci.printInCommandInvoker("Файл не найден. Выполнение скрипта отменено.\n")
        }
    }
}