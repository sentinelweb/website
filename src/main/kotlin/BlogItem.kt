import data.blogItems
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
                ?.let { blogItems.get(props.index) }
                ?: item404

        )
    }

    override fun RBuilder.render() {
        document.title = "Sentinel Blog"
        div { attrs { id = "preloader" } }
        header {
            isHome = false
            changeTheme = props.changeTheme
        }
        main {
            attrs { id = "main" }
            renderHero(state.item)
            renderDetail(state.item)
            blogNav {
                nextTarget = props.index.takeIf { it < blogItems.size - 1 }?.let { blogItems.get(it+1).buildUri() }
                nextTitle = "Next"
                prevTarget = props.index.takeIf { it > 0 }?.let { blogItems.get(it-1).buildUri() }
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

    private fun RBuilder.renderDetail(item: data.BlogItem) {
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
                twitterIcon {
                    attrs.size = 32
                    attrs.round = true
                }
            }
            emailShareButton {
                attrs.url = item.buildUri(true)
                emailIcon {
                    attrs.size = 32
                    attrs.round = true
                }
            }
            facebookShareButton {
                attrs.url = item.buildUri(true)
                facebookIcon {
                    attrs.size = 32
                    attrs.round = true
                }
            }
            linkedinShareButton {
                attrs.url = item.buildUri(true)
                linkedinIcon {
                    attrs.size = 32
                    attrs.round = true
                }
            }
            redditShareButton {
                attrs.url = item.buildUri(true)
                redditIcon {
                    attrs.size = 32
                    attrs.round = true
                }
            }
            whatsappShareButton {
                attrs.url = item.buildUri(true)
                whatsappIcon {
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
//
//"""
//<!-- Hero -->
//		<section class="flex-center background-parallax bg-dark py-14" data-background="img/gallery/85.jpg" data-overlay="black; .8">
//			<div class="page-title-wrapper text-light">
//				<h1 class="page-title">Blog Post Title</h1>
//				<p class="page-subtitle">
//					    <span>March 25, 2018</span>
//					<i class="opacity-05">in</i>
//					<span class="text-links uppercase">
//						<a href="#">Lifestyle</a>
//					</span>
//				</p>
//			</div>
//		</section>
//		<!-- /Hero -->
//
//		<!-- Blog Post Section -->
//		<section class="bg-light pb-6">
//			<div class="container py-8">
//				<div class="row">
//
//					<!-- Blog Post Column -->
//					<div class="col-lg-9">
//
//						<h4 class="uppercase bold">About</h4>
//						<hr class="separator-left">
//						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vero officia commodi, aut culpa, consectetur doloribus aperiam neque quaerat tenetur officiis quod assumenda, fuga voluptas rerum asperiores porro molestiae, debitis rem.</p>
//						<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptatum laboriosam possimus doloremque harum, nam autem quis facilis voluptatibus illo voluptatem, beatae necessitatibus doloribus in, hic veritatis ad rerum minima eligendi.</p>
//
//						<div class="thumbnail-video my-7"
//						     data-src="https://vimeo.com/115041822"
//						     data-poster="img/gallery/108.jpg"></div>
//
//						<blockquote class="mb-7">
//							<p>Whatever you can do or dream you can, begin it. Boldness has genius, power, and magic in it.</p>
//							<footer>-Johann Wolfgang von Goethe</footer>
//						</blockquote>
//
//						<h4 class="uppercase bold mb-5">Post Gallery</h4>
//
//						<!-- GALLERY GRID -->
//						<div class="grid lightbox photo-gallery"
//						     data-columns="2"
//						     data-gutter="2"
//						     data-cell-ratio="5/4"
//						     data-thumbnails="true"
//						     data-thumbnails-pinned="true">
//
//							<a class="grid-item wide lightbox-link"
//							   href="img/gallery/68.jpg"
//							   title="Photo Caption"
//							   data-background="img/gallery/68.jpg"
//							   data-thumbnail="img/gallery/68.jpg"></a>
//
//							<a class="grid-item lightbox-link"
//							   href="img/gallery/2.jpg"
//							   title="Photo Caption"
//							   data-background="img/gallery/2.jpg"
//							   data-thumbnail="img/gallery/2.jpg"></a>
//
//							<a class="grid-item lightbox-link"
//							   href="img/gallery/3.jpg"
//							   title="Photo Caption"
//							   data-background="img/gallery/3.jpg"
//							   data-thumbnail="img/gallery/3.jpg"></a>
//
//							<a class="grid-item lightbox-link"
//							   href="img/gallery/108.jpg"
//							   title="Photo Caption"
//							   data-background="img/gallery/108.jpg"
//							   data-thumbnail="img/gallery/108.jpg"></a>
//
//							<a class="grid-item tall lightbox-link"
//							   href="img/gallery/85.jpg"
//							   title="Photo Caption"
//							   data-background="img/gallery/85.jpg"
//							   data-thumbnail="img/gallery/85.jpg"></a>
//
//							<a class="grid-item lightbox-link"
//							   href="img/gallery/109.jpg"
//							   title="Photo Caption"
//							   data-background="img/gallery/109.jpg"
//							   data-thumbnail="img/gallery/109.jpg"></a>
//
//							<a class="grid-item wide lightbox-link"
//							   href="img/gallery/107.jpg"
//							   title="Photo Caption"
//							   data-background="img/gallery/107.jpg"
//							   data-thumbnail="img/gallery/107.jpg"></a>
//
//						</div>
//						<!-- /GALLERY GRID -->
//
//"""