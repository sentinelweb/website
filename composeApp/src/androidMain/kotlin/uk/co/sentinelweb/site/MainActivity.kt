package uk.co.sentinelweb.site

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import uk.co.sentinelweb.site.util.ScreenSizeProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(ScreenSizeProvider(this))
        }
    }
}

//@Preview
//@Composable
//fun AppAndroidPreview() {
//    App(ScreenSizeProvider())
//}
