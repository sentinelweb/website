import data.blogItems
import data.buildUri
import kotlinx.browser.document
import kotlinx.html.id
import react.*
import react.dom.*

external interface BlogProps : RProps {
    var category: data.Category?
    var changeTheme: () -> Unit
}

data class BlogState(
    val category: data.Category?,
    val displayList: List<data.BlogItem>
) : RState

class Blog(props: BlogProps) : RComponent<BlogProps, BlogState>(props) {

    init {
        state = BlogState(
            props.category,
            props.category
                ?.title?.lowercase()
                ?.let { catName ->
                    blogItems.filter { item ->
                        item.categories.filter {cat -> cat.title.lowercase() == catName }.isNotEmpty()
                    }
                }
                ?: blogItems
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
            renderHero()
            renderBlogList(state.displayList)
            contact {}
        }
        footer {}
    }

    private fun RBuilder.renderHero() {
        section("flex-center background-parallax bg-dark py-14") {
            attrs {
                //https://pixabay.com/photos/satellite-image-city-new-york-1030778/
                setProp("data-background", "img/gallery/satellite-image-1030778_1280.jpg")
                setProp("data-overlay", "black; .3")
            }
            div("page-title-wrapper text-light") {
                h1("page-title") {
                    +(state.category?.title ?: "Blog & News")
                }
            }
        }
    }

    private fun RBuilder.renderBlogList(list: List<data.BlogItem>) {
        section("bg-light pb-6") {
            div("masonry blog") {
                attrs {
                    setProp("data-gutter", "30")
                    setProp("data-columns", "3")
                }
                list.forEach { item ->
                    renderBlogItem(item)
                }
            }
        }
    }

    private fun RBuilder.renderBlogItem(item: data.BlogItem) {
        article {
            val link = item.buildUri()
            a(href = link) {
                img(src = item.img) {}
            }
            div("details serif") {
                h5("bold uppercase") {
                    a(href = link) { +item.title }
                }
                div("small") {
                    span { +item.date }
                    renderCategories(item.categories)
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