package com.zjq.transactionanimdemo

import android.os.Bundle
import android.transition.Scene
import android.transition.Transition
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

class SceneDemoOneActivity : AppCompatActivity() {
    private lateinit var scene1: Scene
    private lateinit var scene2: Scene
    private lateinit var currentScene: Scene
    private lateinit var transition: Transition
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_demo_one)
        val sceneRootFrameLayout = findViewById<FrameLayout>(R.id.sceneRootFrameLayout)
        scene1 = Scene.getSceneForLayout(sceneRootFrameLayout, R.layout.scene1, this)
        scene2 = Scene.getSceneForLayout(sceneRootFrameLayout, R.layout.scene2, this)
        scene1.enter()
        currentScene = scene1
        transition = TransitionInflater.from(this).inflateTransition(R.transition.example_5)
    }

    fun onClick(view: View) {
        currentScene = if (currentScene == scene1) {
            TransitionManager.go(scene2, transition)
            scene2
        } else {
            TransitionManager.go(scene1, transition)
            scene1
        }
    }
}