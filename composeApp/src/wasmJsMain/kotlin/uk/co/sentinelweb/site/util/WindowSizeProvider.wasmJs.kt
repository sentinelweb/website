package uk.co.sentinelweb.site.util

//private val ScreenWidth: String = js("window.innerWidth")
//private val ScreenHeight: String = js("window.innerHeight")
//private val ScreenWidth: String = "300"
//private val ScreenHeight: String = "300"
//private fun screenWidth(): String = js("window.innerWidth")
//private fun screenHeight(): String = js("window.innerHeight")

external object window : JsAny {
    val innerWidth: Int
    var innerHeight: Int
}

actual class WindowSizeProvider {
    actual val width: Float
        get() = window.innerWidth.toFloat()

    actual val height: Float
        get() = window.innerHeight.toFloat()
}
