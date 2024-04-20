package com.zjq.transactionanimdemo

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.transition.ChangeBounds
import androidx.transition.ChangeTransform
import androidx.transition.Fade
import androidx.transition.Scene
import androidx.transition.Transition
import androidx.transition.TransitionManager
import androidx.transition.TransitionSet
import androidx.transition.Visibility

class SceneDemoThreeActivity : AppCompatActivity() {
    private lateinit var avatar: ImageView
    private lateinit var transition: TransitionSet
    private lateinit var scene: Scene
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_demo_three)
        val root = findViewById<FrameLayout>(R.id.root)
        scene = Scene.getSceneForLayout(root, R.layout.scene3, this)
        scene.enter()
        avatar = scene.sceneRoot.findViewById(R.id.avatar)
        transition = TransitionSet()
        transition.ordering = TransitionSet.ORDERING_TOGETHER
        val changeAlpha = CustomChangeAlpha()
        changeAlpha.interpolator = LinearInterpolator()
        changeAlpha.startDelay = 100
        changeAlpha.duration = 3000
        changeAlpha.addTarget(R.id.avatar)
        val changeBounds = ChangeBounds()
        changeBounds.interpolator = LinearInterpolator()
        changeBounds.startDelay = 100
        changeBounds.duration = 3000
        changeBounds.addTarget(R.id.avatar)
        transition.addTransition(changeAlpha)
        transition.addTransition(changeBounds)
    }

    fun onClick(view: View) {
        TransitionManager.go(scene, transition)
        avatar = scene.sceneRoot.findViewById(R.id.avatar)
        avatar.alpha = 0f
        val layoutParams = avatar.layoutParams as ConstraintLayout.LayoutParams
        layoutParams.width = resources.getDimension(R.dimen.dp_130).toInt()
        layoutParams.height = resources.getDimension(R.dimen.dp_130).toInt()
        layoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        avatar.layoutParams = layoutParams
    }
}