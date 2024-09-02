package uk.co.sentinelweb.site.util

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.useContents
import platform.UIKit.UIScreen
@OptIn(ExperimentalForeignApi::class)

actual class WindowSizeProvider {
    private val scale = UIScreen.mainScreen.nativeScale
    actual val width: Float = ((UIScreen.mainScreen.bounds.useContents { size.width }) / scale).toFloat()
    actual val height: Float = ((UIScreen.mainScreen.bounds.useContents { size.height }) / scale).toFloat()
}
