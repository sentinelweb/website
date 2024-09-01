package uk.co.sentinelweb.site

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import sentinelwebsite.composeapp.generated.resources.Res
import sentinelwebsite.composeapp.generated.resources.logo_light
import uk.co.sentinelweb.site.util.ScreenSizeProvider
import kotlin.math.roundToInt

@Composable
@Preview
fun App(sizeProvider: ScreenSizeProvider) {
    MaterialTheme {
        SplashScreen(sizeProvider)
    }
}

@Composable
fun SplashScreen(sizeProvider: ScreenSizeProvider) {
    val fullSize = IntSize(sizeProvider.width.toInt(), sizeProvider.height.toInt())
    val imgSize = IntSize(1460, 320)
    val initialScale = 1f
    val animatedOffsetBoundsLeft =
        remember { Animatable((fullSize.width.toFloat() - imgSize.width) / initialScale) }
    val animatedOffsetBoundsTop =
        remember { Animatable((fullSize.height.toFloat() - imgSize.height) / initialScale) }
    val animatedOffsetBoundsScale = remember { Animatable(initialScale) }

    val animationSpec = tween<Float>(durationMillis = 2000, easing = FastOutSlowInEasing)

    val delayStart: Long = 2000
    val finalScale = 0.2f
    val finalTopLeft = 10f
    LaunchedEffect(Unit) {
        delay(delayStart)
        animatedOffsetBoundsLeft.animateTo(targetValue = finalTopLeft - imgSize.width + imgSize.width * finalScale, animationSpec = animationSpec)
    }
    LaunchedEffect(Unit) {
        delay(delayStart)
        animatedOffsetBoundsTop.animateTo(targetValue = finalTopLeft - imgSize.height + imgSize.height * finalScale, animationSpec = animationSpec)
    }
    LaunchedEffect(Unit) {
        delay(delayStart)
        animatedOffsetBoundsScale.animateTo(targetValue = finalScale, animationSpec = animationSpec)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(painterResource(Res.drawable.logo_light),
            contentDescription = null,
            modifier = Modifier
                .offset {
                    IntOffset(
                        animatedOffsetBoundsLeft.value.roundToInt(),
                        animatedOffsetBoundsTop.value.roundToInt()
                    )
                }
                .scale(animatedOffsetBoundsScale.value) // control the size scaling of your logo
        )
    }
}

@Composable
private fun InitialScreen() {
    var showContent by remember { mutableStateOf(false) }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { showContent = !showContent }) {
            Text("Click me!")
        }
        AnimatedVisibility(showContent) {
            val greeting = remember { Greeting().greet() }
            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(painterResource(Res.drawable.logo_light), null)
                Text("Compose: $greeting")
            }
        }
    }
}
