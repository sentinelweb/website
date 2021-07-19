import data.blogItems
import data.buildImgUri
import data.buildUri
import data.item404
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.await
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.html.*
import org.w3c.dom.HTMLAnchorElement
import org.w3c.dom.asList
import react.*
import react.dom.*


external interface BlogItemProps : RProps {
    var index: Int
    var changeTheme: () -> Unit
}

data class BlogItemState(
    val item: data.BlogItem,
    var contentHtml: String? = null
) : RState

class BlogItem(props: BlogItemProps) : RComponent<BlogItemProps, BlogItemState>(props) {

    init {
        state = BlogItemState(
            props.index
                .takeIf { it >= 0 && it < blogItems.size }
                ?.let { blogItems[props.index] }
                ?: item404

        )
    }

    override fun RBuilder.render() {
        // title
        state.item.title.let{ title ->
            document.title = title
            document.querySelector("meta[name=\"twitter:title\"]")
                ?.setAttribute("content", title)
            document.querySelector("meta[name=\"og:title\"]")
                ?.setAttribute("content", title)

        }
        // description
        (state.contentHtml?.substring(200) ?: state.item.title).let {desc ->
            document.querySelector("meta[name=\"description\"]")
                ?.setAttribute("content", desc);
            document.querySelector("meta[property=\"og:description\"]")
                ?.setAttribute("content", desc)
        }

        state.item.buildImgUri(true).let{ imgUrl ->
            document.querySelector("meta[property=\"og:image\"]")
                ?.setAttribute("content", imgUrl)
        }
        state.item.buildUri(true).let{uri ->
            document.querySelector("meta[property=\"og:url\"]")
                ?.setAttribute("content", uri)
        }

        div { attrs { id = "preloader" } }
        header {
            isHome = false
            changeTheme = props.changeTheme
        }
        main {
            attrs { id = "main" }
            renderHero(state.item)
            renderDetail()
            blogNav {
                nextTarget = props.index.takeIf { it < blogItems.size - 1 }?.let { blogItems[it + 1].buildUri() }
                nextTitle = "Next"
                prevTarget = props.index.takeIf { it > 0 }?.let { blogItems[it - 1].buildUri() }
                prevTitle = "Prev"
            }
            contact {}
            renderShare(state.item)
        }
        footer {}
    }

    private fun RBuilder.renderHero(item: data.BlogItem) {
        section("flex-center background-parallax bg-dark py-14") {
            attrs {
                setProp("data-background", item.img)
                setProp("data-overlay", "black; .3")
            }
            div("page-title-wrapper text-light") {
                h1("page-title") { +item.title }
                p("page-subtitle serif") {
                    span { +item.date }
                    renderCategories(item.categories)
                }
            }

        }
    }

    private fun RBuilder.renderDetail() {
        section("bg-light pb-6 pr-2") {
            div("container py-8") {
                div("col-lg-12 blog-item") {
                    attrs {
                        unsafe {
                            +(state.contentHtml ?: "Loading ...")
                        }
                    }
                }
            }
        }
    }

    private fun RBuilder.renderShare(item: data.BlogItem) {
        span("blog-share-ctnr") {
            twitterShareButton {
                attrs.url = item.buildUri(true)
                attrs.title = item.title
                attrs.via = "sentinelwebtech"
                attrs.hashtags = item.categories.map { it.title }.toTypedArray()
                twitterIcon {
                    attrs.size = 32
                    attrs.round = true
                }
            }
            emailShareButton {
                attrs.url = item.buildUri(true)
                attrs.subject = item.title
                emailIcon {
                    attrs.size = 32
                    attrs.round = true
                }
            }
            facebookShareButton {
                attrs.url = item.buildUri(true)
                attrs.quote = item.title
                attrs.hashtag = item.categories.takeIf { it.isNotEmpty() }?.get(0)?.let { "#" + it.title }
                facebookIcon {
                    attrs.size = 32
                    attrs.round = true
                }
            }
            linkedinShareButton {
                attrs.url = item.buildUri(true)
                attrs.title = item.title
                attrs.source = "https://sentinelweb.co.uk"
                linkedinIcon {
                    attrs.size = 32
                    attrs.round = true
                }
            }
            redditShareButton {
                attrs.url = item.buildUri(true)
                attrs.title = item.title
                redditIcon {
                    attrs.size = 32
                    attrs.round = true
                }
            }
            whatsappShareButton {
                attrs.url = item.buildUri(true)
                attrs.title = item.title
                whatsappIcon {
                    attrs.size = 32
                    attrs.round = true
                }
            }
            pocketShareButton {
                attrs.url = item.buildUri(true)
                attrs.title = item.title
                pocketIcon {
                    attrs.size = 32
                    attrs.round = true
                }
            }
            telegramShareButton {
                attrs.url = item.buildUri(true)
                attrs.title = item.title
                telegramIcon {
                    attrs.size = 32
                    attrs.round = true
                }
            }
        }
    }

    override fun componentDidMount() {
        fetch(state.item)
    }

    private fun fetch(item: data.BlogItem) {
        MainScope().launch {
            val rx = fetchContent(item.contentUri)
            setState {
                contentHtml = rx
            }
            hljs.highlightAll()
            document.querySelectorAll(".blog-item a").asList().forEach {
                val htmlAnchorElement = it as HTMLAnchorElement
                if (it.href.startsWith("http")) {
                    htmlAnchorElement.target = "_blank"
                }
            }
        }
    }

}

fun RDOMBuilder<HtmlBlockTag>.renderCategories(categories: List<data.Category>) {
    categories
        .takeIf { it.isNotEmpty() }
        ?.let { cats ->
            i("opacity-05") { +" in " }
            cats.forEachIndexed { i, cat ->
                span("blog-cat-link uppercase") {
                    a(href = "$BLOG_PATH_CAT${cat.title}") { +cat.title }
                    +(if (i < cats.size - 1) ", " else "")
                }
            }
        }
}

fun RBuilder.blogItem(handler: BlogItemProps.() -> Unit): ReactElement {
    return child(BlogItem::class) {
        this.attrs(handler)
    }
}

suspend fun fetchContent(relative: String): String = coroutineScope {
    window
        .fetch(relative)
        .await()
        .text()
        .await()
}