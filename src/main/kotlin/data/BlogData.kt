package data

import BLOG_ITEM_PATH_TITLE
import kotlinx.browser.window

data class BlogItem(
    val img: String,
    val title: String,
    val date: String,
    val categories: List<Category>,
    val contentUri: String
)

fun BlogItem.unslashedUri() = contentUri.replace("/", "_")

fun BlogItem.buildUri(absolute: Boolean = false) =
    (if (absolute) window.location.origin else "") + "$BLOG_ITEM_PATH_TITLE${unslashedUri()}"

fun BlogItem.buildImgUri(absolute: Boolean = true) =
    (if (absolute) window.location.origin else "") + this.img

fun BlogItem.cleanDescription(content: String?) =
    content?.replace("(<([^>]+)>)".toRegex(), "")
        ?: title

data class Category(
    val title: String
)

val catgories = listOf(
    Category("Code"),
    Category("Android"),
    Category("iOS"),
    Category("Web"),
    Category("Process"),
    Category("UX")
)

private val catgoriesLookup = catgories.associateBy { it.title.lowercase() }
private fun cats(vararg titles: String) = titles.map { catgoriesLookup[it] ?: throw Exception("Invalid category") }

val blogItems = listOf<BlogItem>(
    // https://pixabay.com/photos/stopwatch-gears-keyboard-work-3699322/
    BlogItem(
        "blog/img/0-stopwatch-3699322_1280.jpg",
        "The importance of process",
        "19 June, 2019",
        cats("process"),
        "blog/0-the-importance-of-process.html"
    ),
    // https://pixabay.com/photos/piano-piano-keys-keyboard-3505109/
    BlogItem(
        "blog/img/2-piano-3505109_1280.jpg",
        "Setting up MDC themes for Jetpack Compose",
        "14 April, 2021",
        cats("android", "code"),
        "blog/2-setup-theme-in-jetpack-compose.html"
    ),
    // https://pixabay.com/photos/architecture-skyscraper-urban-city-768432/
    BlogItem(
        "blog/img/1-architecture-768432_1280.jpg",
        "Using MVI Kotlin with coroutines",
        "24 May, 2021",
        cats("android", "code"),
        "blog/1-using-mvi-kotlin-with-coroutines.html"
    ),
    // https://pixabay.com/photos/background-geometric-triangle-3045402/
//    BlogItem(
//        "blog/img/3-background-3045402_1280.png",
//        "Using a web template with Kotlin JS / React",
//        "22 June, 2021",
//        cats("web", "code"),
//        "blog/3-using-a-web-template-with-kotlin-js-react.html"
//    )
).reversed()

val item404 = BlogItem(
    "img/gallery/404-girl-1208283_1280.jpg", "Not found", "-", listOf(),
    "blog/404-not-found.html"
)
