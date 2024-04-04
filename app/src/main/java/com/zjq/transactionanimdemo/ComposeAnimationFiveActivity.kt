package com.zjq.transactionanimdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalAnimationApi::class)
class ComposeAnimationFiveActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier.fillMaxSize()) {
                var isVisible by remember {
                    mutableStateOf(false)
                }
                Button(onClick = { isVisible = !isVisible }) {
                    Text(text = "Toggle")
                }
                AnimatedContent(
                    targetState = isVisible,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    content = {
                        if (isVisible) {
                            Box(modifier = Modifier.background(Color.Red))
                        } else {
                            Box(modifier = Modifier.background(Color.Green))
                        }
                    },
                    transitionSpec = {
                        slideInHorizontally(initialOffsetX = {
                            -it / 2
                        }) with slideOutHorizontally(
                            targetOffsetX = {
                                it / 2
                            }
                        )
                    }
                )
            }
        }
    }
}