package uk.co.sentinelweb.site.util

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics

actual class ScreenSizeProvider(context: Context) {
    private val resources: Resources = context.resources
    private val metrics: DisplayMetrics = resources.displayMetrics
    actual val width: Float = metrics.widthPixels / metrics.density
    actual val height: Float = metrics.heightPixels / metrics.density
}
