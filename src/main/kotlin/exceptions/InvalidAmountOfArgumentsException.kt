package exceptions

import commands.Command

class InvalidAmountOfArgumentsException(command: Command, amount: Int): Exception() {
    private val name: String = command.toString()
    private val realAmount: Int = command.tokenAmount

    override val message: String = "Command $name need $realAmount arguments, $amount given"
}