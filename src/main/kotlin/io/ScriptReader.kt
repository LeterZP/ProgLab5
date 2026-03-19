package io

import core.CommandInvoker
import java.io.File
import java.io.FileNotFoundException

class ScriptReader(val ci: CommandInvoker) {
    fun startScript(file: String) {
        try {
            val commands: String = File(file).readText()
            ci.addNext(commands)
        } catch (e: FileNotFoundException) {
            println("Файл не найден. Выполнение скрипта отменено.")
        }
    }
}