import data.blogItems
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.css.CSSBuilder
import kotlinx.css.Color
import kotlinx.css.backgroundColor
import kotlinx.css.html
import org.w3c.dom.HTMLHtmlElement
import org.w3c.dom.events.Event
import org.w3c.dom.get
import org.w3c.dom.url.URLSearchParams
import react.*
import react.dom.div
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch
import styled.injectGlobal

const val BLOG_PATH = "/blog.html"
const val BLOG_CAT = "cat"
const val BLOG_PATH_CAT = "/blog.html?$BLOG_CAT="
const val BLOG_ITEM_PATH = "/blog_item.html"
const val BLOG_ITEM_INDEX = "index"
const val BLOG_ITEM_PATH_INDEX = "/blog_item.html?$BLOG_ITEM_INDEX="

const val STORAGE_LIGHT_THEME = "LIGHT_THEME"

external interface AppProps : RProps {
    var x: Boolean
}

data class AppState(var lightTheme: Boolean) : RState

class App(props: AppProps) : RComponent<AppProps, AppState>(props) {

    init {
        state = AppState(window.localStorage.get(STORAGE_LIGHT_THEME)?.toBoolean() ?: false)
    }

    override fun RBuilder.render() {
        div(if (state.lightTheme) "light-navigation" else "") {
            browserRouter {
                switch {
                    route("/", exact = true) {
                        onePage { changeTheme = {upadteTheme()} }
                    }
                    route<RProps>(BLOG_PATH) { props ->
                        console.log("blog")
                        blog {
                            changeTheme = {upadteTheme()}
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
                                    index = it
                                }
                            }
                            ?: run { blog { changeTheme = {upadteTheme()}} }
                    }
                }
            }
        }
    }

    private fun upadteTheme() {
        val isLight = !state.lightTheme
        window.localStorage.setItem(STORAGE_LIGHT_THEME, isLight.toString())
        setState { lightTheme = isLight }
        val styles = CSSBuilder().apply {
            html {
                backgroundColor = if (isLight) Color.white else Color.black
            }
        }
        injectGlobal(styles.toString())
    }

}

fun RBuilder.app(handler: AppProps.() -> Unit): ReactElement {
    return child(App::class) {
        this.attrs(handler)
    }
}


