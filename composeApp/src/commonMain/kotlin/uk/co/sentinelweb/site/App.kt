package uk.co.sentinelweb.site

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.util.lerp
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
        SplashScreen1(sizeProvider)
    }
}

@Composable
fun SplashScreen1(sizeProvider: ScreenSizeProvider) {
    val fullSize = IntSize(sizeProvider.width.toInt(), sizeProvider.height.toInt())
    val imgSize = IntSize(292, 64)
    val initialScale = 5f
    val animatedOffsetBoundsLeft =
        remember { Animatable((fullSize.width.toFloat() - imgSize.width) / initialScale ) }
    val animatedOffsetBoundsTop =
        remember { Animatable((fullSize.height.toFloat() - imgSize.height) / initialScale ) }
    val animatedOffsetBoundsScale = remember { Animatable(initialScale) }

    val animationSpec = tween<Float>(durationMillis = 2000, easing = FastOutSlowInEasing)

    val delayStart: Long = 2000
    LaunchedEffect(Unit) {
        delay(delayStart)
        animatedOffsetBoundsLeft.animateTo(targetValue = 10f, animationSpec = animationSpec)
    }
    LaunchedEffect(Unit) {
        delay(delayStart)
        animatedOffsetBoundsTop.animateTo(targetValue = 10f, animationSpec = animationSpec)
    }
    LaunchedEffect(Unit) {
        delay(delayStart)
        animatedOffsetBoundsScale.animateTo(targetValue = 1f, animationSpec = animationSpec)
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(painterResource(Res.drawable.logo_light),
            contentDescription = null,
            modifier = Modifier
                .scale(animatedOffsetBoundsScale.value) // control the size scaling of your logo
                .offset {
                    IntOffset(
                        animatedOffsetBoundsLeft.value.roundToInt(),
                        animatedOffsetBoundsTop.value.roundToInt()
                    )
                }

        )
    }


}

@Composable
fun SplashScreen() {
    val transition = rememberInfiniteTransition()
    val angle by transition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            tween(3000, easing = FastOutSlowInEasing),
            RepeatMode.Restart
        )
    )
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        val offsetX = lerp(0f, -1000f, angle) // substitute -1000f with the actual left side offset you need
        val offsetY = lerp(0f, -1000f, angle) // substitute -1000f with the actual top side offset you need
        Image(painterResource(Res.drawable.logo_light),
            contentDescription = null,
            modifier = Modifier
                .scale(lerp(1f, 0.5f, angle)) // change 1f and 0.5f to control the size scaling of your logo
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
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
