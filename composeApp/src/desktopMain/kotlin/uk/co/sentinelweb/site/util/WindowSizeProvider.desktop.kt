package uk.co.sentinelweb.site.util

import androidx.compose.ui.unit.IntSize

//actual class WindowSizeProvider(window: ComposeWindow) {
//    actual val width: Float = window.width.toFloat()
//    actual val height: Float = window.height.toFloat()
//    init {
//        println("width:$width x height:$height")
//    }
//}
//
 actual class WindowSizeProvider(size: IntSize) {
    actual val width: Float = size.width.toFloat()
    actual val height: Float = size.height.toFloat()
    init {
        println("width:$width x height:$height")
    }
}

//actual class WindowSizeProvider(
//    actual val width: Float,
//    actual val height: Float
//) {
//    init {
//        println("width:$width x height:$height")
//    }
//}

