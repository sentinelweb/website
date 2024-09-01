package uk.co.sentinelweb.site

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import uk.co.sentinelweb.site.util.ScreenSizeProvider

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "SentinelWebsite",
    ) {
        App(ScreenSizeProvider())
    }
}
