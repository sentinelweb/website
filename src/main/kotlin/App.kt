import kotlinx.browser.window
import org.w3c.dom.events.Event
import org.w3c.dom.url.URLSearchParams
import react.RBuilder
import react.RProps
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

const val BLOG_PATH = "/blog.html"
const val BLOG_ITEM_PATH = "/blog_item.html"

interface IndexProps : RProps {
    var index: Int
}

fun RBuilder.app() =
    browserRouter {
        console.log("route")
        switch {
            route("/", exact = true) {
                onePage { lightTheme = true }
            }
            route(BLOG_PATH) {
                console.log("blog:")
                blog { lightTheme = true }
            }
            route<IndexProps>(BLOG_ITEM_PATH) { props ->
                val query = URLSearchParams(props.location.search);
                console.log("item:" + query)
                query.get("index")?.toInt()
                    ?.let {
                        blogItem {
                            lightTheme = true
                            index = it
                        }
                    }
                    ?: run { blog { lightTheme = true } }
            }
        }
    }


