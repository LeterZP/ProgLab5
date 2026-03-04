package commands

import core.CollectionManager

abstract class Command(private val cm: CollectionManager) {
    val tokenAmount: Int = 0

    open fun execute(token: List<String>) {
        println("...command execution...")
    }
    open fun describe(): String {
        return "Just a default command, nothing more, nothing less"
    }

    override fun toString(): String {
        return "default command"
    }
}