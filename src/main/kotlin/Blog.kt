import data.blogItems
import kotlinx.browser.document
import kotlinx.html.id
import react.*
import react.dom.*

external interface BlogProps : RProps {
    var lightTheme: Boolean // todo consolidate with onepage
    val category: data.Category?
}

data class BlogState(val category: data.Category?) : RState

class Blog(props: BlogProps) : RComponent<BlogProps, BlogState>(props) {

    init {
        state = BlogState(props.category)
    }

    override fun RBuilder.render() {
        document.title = "Sentinel Blog"
        div(if (props.lightTheme) "light-navigation" else "") {
            div { attrs { id = "preloader" } }
            header { isHome = false }
            main {
                attrs { id = "main" }
                hero()
                blogList()
                // todo navigation
            }
            footer {}
        }
    }

    private fun RBuilder.hero() {
        section("flex-center background-parallax bg-dark py-14") {
            attrs {
                //https://pixabay.com/photos/satellite-image-city-new-york-1030778/
                setProp("data-background", "img/gallery/satellite-image-1030778_1280.jpg")
                setProp("data-overlay", "black; .8")
            }
            div("page-title-wrapper text-light") {
                h1("page-title") {
                    +"Blog & News"
                }
            }
        }
    }

    private fun RBuilder.blogList() {
        section("bg-light pb-6") {
            div("masonry blog") {
                attrs {
                    setProp("data-gutter", "30")
                    setProp("data-columns", "3")
                }
                blogItems.forEachIndexed { i, item ->
                    blogItem(item, i)
                }
            }
        }
    }

    private fun RBuilder.blogItem(item: data.BlogItem, index: Int) {
        article {
            val link = "blog_item.html?index=$index"
            a(href = link) {
                img(src = item.img) {}
            }
            div("details") {
                h5("bold uppercase") {
                    a(href = link) { +item.title }
                }
                div("serif small") {
                    span { +item.date }
                    i { +" in " }
                    span("text-links uppercase") {
                        a(href = item.category.link) { +item.category.title }
                    }
                }
            }
        }
    }

}

fun RBuilder.blog(handler: BlogProps.() -> Unit): ReactElement {
    return child(Blog::class) {
        this.attrs(handler)
    }
}

//"""
//<!-- Hero -->
//		<section class="flex-center background-parallax bg-dark py-14" data-background="img/gallery/21.jpg" data-overlay="black; .8">
//			<div class="page-title-wrapper text-light">
//				<h1 class="page-title">Blog & News</h1>
//			</div>
//		</section>
//		<!-- /Hero -->
//
//		<!-- Blog Section -->
//		<section class="bg-light pb-6">
//
//			<!-- Blog -->
//			<div class="masonry blog" data-gutter="30" data-columns="3">
//
//				<!-- Blog Item -->
//				<article>
//					<a href="#">
//						<img src="img/gallery/108.jpg" alt="">
//					</a>
//					<div class="details">
//						<h5 class="bold uppercase">
//							<a href="#">Martian Child</a>
//						</h5>
//						<div class="serif small">
//							<span>March 25, 2018</span>
//							<i class="opacity-05">in</i>
//							<span class="text-links uppercase">
//								<a href="#">Lifestyle</a>
//							</span>
//						</div>
//					</div>
//				</article>
//				<!-- /Blog Item -->
//
//			</div>
//			<!-- /Blog -->
//
//		</section>
//		<!-- /Blog Section -->
//
//		<!-- Blog Navigation -->
//		<div class="project-nav">
//			<div class="col-6">
//				<a href="#" class="disabled">
//					<i class="fa fa-long-arrow-left opacity-03"></i>
//					<h6>Newer Posts</h6>
//				</a>
//			</div>
//			<div class="col-6">
//				<a href="#">
//					<i class="fa fa-long-arrow-right opacity-03"></i>
//					<h6>Older Posts</h6>
//				</a>
//			</div>
//		</div>
//		<!-- /Blog Navigation -->
//"""