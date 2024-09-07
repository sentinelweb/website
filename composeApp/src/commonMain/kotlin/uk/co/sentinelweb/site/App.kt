package uk.co.sentinelweb.site

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.round
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import sentinelwebsite.composeapp.generated.resources.Res
import sentinelwebsite.composeapp.generated.resources.logo_light
import uk.co.sentinelweb.site.util.WindowSizeProvider
import kotlin.math.roundToInt

val absolutePosition =  mutableStateOf(Offset.Zero)
//fun calculateGlobalPosition(coordinates: LayoutCoordinates?) {
//    coordinates?.let {
//        val localPosition = it.positionInParent()
//        absolutePosition.value += localPosition
//        println("localPosition:$localPosition, absolutePosition:${absolutePosition.value}")
//        calculateGlobalPosition(it.parentCoordinates)
//    }
//}

@Composable
@Preview
fun App(sizeProvider: WindowSizeProvider) {
    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize().background(Color.LightGray)
            .onGloballyPositioned { coordinates ->
            // Reset the position value before calculation
            absolutePosition.value = Offset.Zero
            //calculateGlobalPosition(coordinates)
                println("positionInWindow(): ${coordinates.positionInWindow()}")
                println("positionInRoot(): ${coordinates.positionInRoot()}")
                println("findRootCoordinates() - window pixelSize: ${coordinates.findRootCoordinates().size}")
                println("localToRoot(Offset.Zero): ${coordinates.localToRoot(Offset.Zero)}")
        }) {
            //SplashScreen(absolutePosition)
            AnimationTest()
            Column {
                //Text(1.dp.value.toString())
                Text(LocalDensity.current.density.toString())
                //Text("${sizeProvider.width} x ${sizeProvider.height}")
            }
        }
    }
}


@Preview
@Composable
fun AnimationTest() {

    Box(
        modifier = Modifier.fillMaxSize().border(2.dp, Color.Red),
        contentAlignment = Alignment.Center
    ) {

        var initialSize by remember {
            mutableStateOf(IntSize.Zero)
        }


        var initialOffset by remember {
            mutableStateOf(IntOffset.Zero)
        }

        val animatable by remember {
            mutableStateOf<Animatable<IntOffset, AnimationVector2D>>(
                Animatable(
                    IntOffset.Zero,
                    IntOffset.VectorConverter
                )
            )
        }
        var logoVisible by remember { mutableStateOf(false) }

        val scale = remember {
            Animatable(1f)
        }

        val pauseBeforeTransition: Int = 2000
        LaunchedEffect(Unit) {
            logoVisible = true
            delay(pauseBeforeTransition.toLong())
            val animationSpec =
                tween<IntOffset>(durationMillis = pauseBeforeTransition, easing = FastOutSlowInEasing)
            val animationSpecScale =
                tween<Float>(durationMillis = pauseBeforeTransition, easing = FastOutSlowInEasing)

            launch {
                scale.animateTo(
                    targetValue = .2f,
                    animationSpec = animationSpecScale
                )
            }

            launch {
                animatable.snapTo(IntOffset.Zero)
                animatable.animateTo(
                    targetValue = IntOffset(

                        // .4f comes from (initial width - final width)/2 = (1-.2f)/2
                        (-initialOffset.x - initialSize.width * .4f).toInt(),
                        (-initialOffset.y - initialSize.height * .4f).toInt()
                    ),
                    animationSpec = animationSpec
                )
            }
        }

        Text(
            modifier = Modifier.align(Alignment.BottomEnd),
            text = "initialSize: $initialSize, initialOffset: $initialOffset"
        )
        AnimatedVisibility(
            visible = logoVisible,
            enter = fadeIn(tween(durationMillis = 1000, easing = FastOutSlowInEasing)),
            modifier = Modifier
                .graphicsLayer {
                    translationX = animatable.value.x.toFloat()
                    translationY = animatable.value.y.toFloat()
                    scaleX = scale.value
                    scaleY = scale.value
                }
                .onGloballyPositioned {
                    if (initialOffset == IntOffset.Zero) {
                        initialOffset = it.positionInParent().round()
                    }
                    if (initialSize == IntSize.Zero) {
                        initialSize = it.size
                    }
                }
                // This is optional, it can be any size
                // but what we actually need to get is size of Composable
                //.size(150.dp)
                .width(1460.dp)
                .height(320.dp),
        ) {
            Image(

                painter = painterResource(Res.drawable.logo_light),
                contentDescription = null
            )
        }
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


@Composable
fun SplashScreen(boxPosition: MutableState<Offset>) {
    //val fullSize = IntSize(sizeProvider.width.toInt(), sizeProvider.height.toInt())
    val screenSize = remember { mutableStateOf(IntSize.Zero) }
    BoxWithConstraints(modifier = Modifier
        .fillMaxSize()
//        .onGloballyPositioned { coordinates ->
//            boxPosition.value = coordinates.positionInWindow()
//                .also { println("onGloballyPositioned: $it") }
//        }
    )
    {
        screenSize.value = IntSize(this.constraints.maxWidth, this.constraints.maxHeight)  // The real bounds you
        val imgSize = IntSize(1460, 320)
        val initialScale = 1f
        val animatedOffsetBoundsLeft =
            remember { Animatable((screenSize.value.width.toFloat() - imgSize.width) / initialScale) }
        val animatedOffsetBoundsTop =
            remember { Animatable((screenSize.value.height.toFloat() - imgSize.height) / initialScale) }
        val animatedOffsetBoundsScale = remember { Animatable(initialScale) }

        val animationSpec = tween<Float>(durationMillis = 2000, easing = FastOutSlowInEasing)

        val delayStart: Long = 2000
        val finalScale = 0.2f
        val finalTop = 10f + boxPosition.value.y
        val finalLeft = 10f + boxPosition.value.x
        LaunchedEffect(Unit) {
            delay(delayStart)
            animatedOffsetBoundsLeft.animateTo(
                targetValue = finalLeft - imgSize.width + imgSize.width * finalScale,
                animationSpec = animationSpec
            )
        }
        LaunchedEffect(Unit) {
            delay(delayStart)
            animatedOffsetBoundsTop.animateTo(
                targetValue = finalTop - imgSize.height + imgSize.height * finalScale,
                animationSpec = animationSpec
            )
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
}
