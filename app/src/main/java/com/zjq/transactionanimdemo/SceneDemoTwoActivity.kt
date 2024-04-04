package com.zjq.transactionanimdemo

import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.transition.ChangeBounds
import androidx.transition.Fade
import androidx.transition.Scene
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet

class SceneDemoTwoActivity : AppCompatActivity() {
    private lateinit var scene1: Scene
    private lateinit var scene2: Scene
    private lateinit var currentScene: Scene
    private lateinit var transitionSet: TransitionSet
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_demo_one)
        val sceneRootFrameLayout = findViewById<FrameLayout>(R.id.sceneRootFrameLayout)
        scene1 = Scene.getSceneForLayout(sceneRootFrameLayout, R.layout.scene1, this)
        scene2 = Scene.getSceneForLayout(sceneRootFrameLayout, R.layout.scene2, this)
        scene1.enter()
        currentScene = scene1
        val cbBounds = ChangeBounds()
        cbBounds.duration = 500
        cbBounds.interpolator = LinearInterpolator()

        val inFade = Fade(Fade.MODE_IN)
        inFade.duration = 250
        inFade.startDelay = 400
        inFade.addTarget(R.id.head_tv)

        val outFade = Fade(Fade.MODE_OUT)
        outFade.duration = 50
        outFade.addTarget(R.id.head_tv)

        transitionSet = TransitionSet()
        transitionSet.ordering = TransitionSet.ORDERING_TOGETHER
        transitionSet.addTransition(cbBounds)
        transitionSet.addTransition(inFade)
        transitionSet.addTransition(outFade)
    }

    fun onClick(view: View) {
        currentScene = if (currentScene == scene1) {
            TransitionManager.go(scene2, transitionSet)
            scene2
        } else {
            TransitionManager.go(scene1, transitionSet)
            scene1
        }
    }
}