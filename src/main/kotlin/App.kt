import kotlinx.browser.window
import org.w3c.dom.events.Event
import react.RBuilder
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

const val BLOG_PATH = "/blog.html"

fun RBuilder.app() =
    browserRouter {
        console.log("route")
        switch {
            route("/", exact = true) {
                console.log("home")
                onePage { lightTheme = true }
            }
            route(BLOG_PATH) {
                console.log("blog")
                blog { lightTheme = true }
            }
           // window.dispatchEvent( Event("load"))
        }
    }


