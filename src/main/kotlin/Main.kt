import core.CollectionManager
import core.InteractiveMode

fun main() {
    val cm: CollectionManager = CollectionManager(System.getenv("SAVE_FILE"))
    val im: InteractiveMode = InteractiveMode(cm)
    im.start()
}