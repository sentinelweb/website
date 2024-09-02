package uk.co.sentinelweb.site

import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import uk.co.sentinelweb.site.util.WindowSizeProvider

fun main() = application {
    val windowSize = IntSize(1024, 768)
    Window(
        onCloseRequest = ::exitApplication,
        title = "Sentinel Website",
        state = WindowState(width = windowSize.width.dp, height = windowSize.height.dp)
    ) {
        App(WindowSizeProvider(windowSize))
    }
}
