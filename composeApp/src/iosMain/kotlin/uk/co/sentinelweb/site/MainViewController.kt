package uk.co.sentinelweb.site

import androidx.compose.ui.window.ComposeUIViewController
import uk.co.sentinelweb.site.util.WindowSizeProvider

fun MainViewController() = ComposeUIViewController { App(WindowSizeProvider()) }
