package uk.co.sentinelweb.site.util

import java.awt.Dimension
import java.awt.Toolkit

actual class ScreenSizeProvider {
    private val screenSize: Dimension = Toolkit.getDefaultToolkit().screenSize
    actual val width: Float = screenSize.width.toFloat()
    actual val height: Float = screenSize.height.toFloat()
}
