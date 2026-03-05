import core.CollectionManager
import core.InteractiveMode

fun main() {
    val cm: CollectionManager = CollectionManager()
    val im: InteractiveMode = InteractiveMode(cm)
    im.start()
    println("Sorry, the project is still WIP, thanks for understanding!")
}