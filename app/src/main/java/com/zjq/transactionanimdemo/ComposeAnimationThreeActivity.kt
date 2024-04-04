package com.zjq.transactionanimdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateInt
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class ComposeAnimationThreeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                var isVisible by remember {
                    mutableStateOf(false)
                }
                var isRound by remember {
                    mutableStateOf(false)
                }
                val transition = updateTransition(
                    targetState = isRound,
                    label = null
                )
                Button(onClick = {
                    isVisible = !isVisible
                    isRound = !isRound
                }) {
                    Text(text = "Toggle")
                }
//                val borderRadius by animateIntAsState(
//                    targetValue = if (isRound) 100 else 0,
//                    animationSpec = tween(
//                        durationMillis = 500,
//                        delayMillis = 500,
//                        easing = FastOutLinearInEasing
//                    )
//                )
                val borderRadius by transition.animateInt(
                    transitionSpec = {tween(2000)},
                    label = "borderRadius",
                    targetValueByState = { isRound ->
                        if (isRound) 100 else 0
                    }
                )
                val color by transition.animateColor(
                    transitionSpec = { tween(100) },
                    label = "color",
                    targetValueByState = { isRound ->
                        if (isRound) Color.Green else Color.Red
                    }
                )
                Box(modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(borderRadius))
                    .background(color)
                ) {
                }
            }
        }
    }
}