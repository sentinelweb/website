import kotlinx.browser.document
import react.dom.render

fun main() {

    val root = document.getElementById("root")
    render(root) {
        app()
    }
}