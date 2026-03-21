import core.CollectionManager
import core.InteractiveMode

fun main() {
    val save: String = System.getenv("SAVE_FILE") ?: "save.json"
    val cm: CollectionManager = CollectionManager(save)
    val im: InteractiveMode = InteractiveMode(cm)
    im.start()
}