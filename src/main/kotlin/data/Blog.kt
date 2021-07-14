package data


data class BlogItem(
    val img: String,
    val title: String,
    val date: String,
    val category: Category,
    val contentUri: String
)

data class Category(
    val title: String,
    val link: String
)

val catgories = listOf(
    Category("Code", "/blog/category/code"),
    Category("Process", "/blog/category/process"),
    Category("Devops", "/blog/category/devops"),
)

val blogItems = listOf(
    BlogItem(
        "img/gallery/satellite-image-1030778_1280.jpg", "Code magic", "25 jan", catgories.get(0),
        "blog/0-code-magic.html"
    ),
    BlogItem("img/gallery/network-4143317_1280.jpg", "Working together", "4 Apr", catgories.get(1),
        "blog/0-code-magic.html"),
    BlogItem("img/gallery/archer-2345211_1280.jpg", "Shooting straight", "7 Apr", catgories.get(2),
        "blog/0-code-magic.html"),
    BlogItem(
        "img/gallery/board-2440249_1280.jpg",
        "Getting the most out of your life", "15 May",
        catgories.get(0),
        "blog/0-code-magic.html"
    )
)
