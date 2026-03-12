package exceptions

class ProgramExitException(): Exception() {
    override val message: String = "Программа остановлена"
}