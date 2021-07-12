import kotlinx.browser.document
import kotlinx.browser.window
import react.dom.render

fun main() {
    render(document.getElementById("root")) {
        onePage {
             lightTheme = false
        }
    }
}