package uk.co.sentinelweb.site

import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import uk.co.sentinelweb.site.util.WindowSizeProvider

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        App(WindowSizeProvider())
    }
}
