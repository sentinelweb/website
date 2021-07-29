import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.html.unsafe
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.asList
import react.*
import react.dom.*

external fun require(module:String): dynamic

fun RBuilder.renderHero(title: String, imgUrl: String, darkNess: String) {
    section("flex-center background-parallax bg-dark py-14") {
        attrs {
            setProp("data-background", imgUrl)
            setProp("data-overlay", "black; $darkNess")
        }
        div("page-title-wrapper text-light") {
            h1("page-title") {
                +title
            }
        }
    }
}

fun RComponent<out RProps, out ContentState>.fetchContent(contentUri: String) {
    MainScope().launch {
        val rx = doFetch(contentUri)
        setState {
            contentHtml = rx
        }
    }
}

open class ContentState constructor(open var contentHtml:String? = null):RState

fun RBuilder.renderContent(contentHtml:String?) {
    section("bg-light pb-6 pr-2") {
        div("container py-8") {
            div("col-lg-12 content-item") {
                attrs {
                    unsafe {
                        +(contentHtml ?: "Loading ...")
                    }
                }
            }
        }
    }
}
suspend fun doFetch(relative: String): String = coroutineScope {
    window
        .fetch(relative)
        .await()
        .text()
        .await()
}