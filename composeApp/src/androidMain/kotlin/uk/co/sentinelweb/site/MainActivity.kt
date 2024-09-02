package uk.co.sentinelweb.site

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import uk.co.sentinelweb.site.util.WindowSizeProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(WindowSizeProvider(this))
        }
    }
}

//@Preview
//@Composable
//fun AppAndroidPreview() {
//    App(ScreenSizeProvider())
//}
