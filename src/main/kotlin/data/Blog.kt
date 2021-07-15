package data


data class BlogItem(
    val img: String,
    val title: String,
    val date: String,
    val categories: List<Category>,
    val contentUri: String
)

data class Category(
    val title: String
)

val catgories = listOf(
    Category("Code"),
    Category("Process"),
    Category("Devops"),
)

val blogItems = listOf(
    BlogItem(
        "img/gallery/satellite-image-1030778_1280.jpg", "Code magic", "25 jan", catgories,
        "blog/0-code-magic.html"
    ),
    BlogItem("img/gallery/network-4143317_1280.jpg", "Working together", "4 Apr", listOf(catgories.get(1)),
        "blog/0-code-magic.html"),
    BlogItem("img/gallery/archer-2345211_1280.jpg", "Shooting straight", "7 Apr", listOf(catgories.get(2)),
        "blog/0-code-magic.html"),
    BlogItem(
        "img/gallery/board-2440249_1280.jpg",
        "Getting the most out of your life", "15 May",
        listOf(catgories.get(0)),
        "blog/0-code-magic.html"
    )
)

val item404 = BlogItem(
    "img/gallery/404-girl-1208283_1280.jpg", "Not found", "-", listOf(),
    "blog/404-not-found.html"
)
