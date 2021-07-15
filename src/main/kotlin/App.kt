import data.blogItems
import kotlinx.browser.window
import org.w3c.dom.events.Event
import org.w3c.dom.url.URLSearchParams
import react.RBuilder
import react.RProps
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

const val BLOG_PATH = "/blog.html"
const val BLOG_CAT = "cat"
const val BLOG_PATH_CAT = "/blog.html?$BLOG_CAT="
const val BLOG_ITEM_PATH = "/blog_item.html"
const val BLOG_ITEM_INDEX = "index"
const val BLOG_ITEM_PATH_INDEX = "/blog_item.html?$BLOG_ITEM_INDEX="

fun RBuilder.app() =
    browserRouter {
        console.log("route")
        switch {
            route("/", exact = true) {
                onePage { lightTheme = true }
            }
            route<RProps>(BLOG_PATH) { props ->
                console.log("blog")
                blog {
                    lightTheme = true
                    category = URLSearchParams(props.location.search)
                        .get(BLOG_CAT)
                        ?.lowercase()
                        ?.let { cat -> data.catgories.find { it.title.lowercase() == cat } }
                }
            }
            route<RProps>(BLOG_ITEM_PATH) { props ->
                console.log("item")
                URLSearchParams(props.location.search)
                    .get(BLOG_ITEM_INDEX)?.toInt()
                    ?.also { console.log("itemIndex:$it") }
                    //?.takeIf { it > 0 && it < blogItems.size }
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


