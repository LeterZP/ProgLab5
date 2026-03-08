package exceptions

import commands.Command

class InvalidAmountOfArgumentsException(private val command: Command, private val amount: Int): Exception() {
    private val name: String = command.getName()
    private val realAmount: Int = command.tokenAmount

    override val message: String = "Команда $name принимает только $realAmount аргументов, а не $amount"
}