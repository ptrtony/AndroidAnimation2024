package com.zjq.transactionanimdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.Scene
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class SceneDemoFourActivity : AppCompatActivity() {
    private lateinit var scene: Scene
    private lateinit var transition: TransitionSet
    private lateinit var text1: TextView
    private lateinit var text2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scene_demo_four)
        val root = findViewById<FrameLayout>(R.id.root)
        scene = Scene.getSceneForLayout(root, R.layout.scene4, this)
        scene.enter()
        initView(scene.sceneRoot)
        transition = TransitionSet()
        transition.ordering = TransitionSet.ORDERING_TOGETHER
        val changeTextSize = CustomChangeTextSize()
        changeTextSize.startDelay = 300
        changeTextSize.interpolator = LinearInterpolator()
        changeTextSize.duration = 3000
        changeTextSize.addTarget(R.id.text1)
        changeTextSize.addTarget(R.id.text2)
        val changeBounds = ChangeBounds()
        changeBounds.startDelay = 300
        changeBounds.interpolator = LinearInterpolator()
        changeBounds.duration = 3000
        changeBounds.addTarget(R.id.text1)
        changeBounds.addTarget(R.id.text2)
        transition.addTransition(changeBounds)
        transition.addTransition(changeTextSize)

    }

    private fun initView(view: View) {
        text1 = view.findViewById(R.id.text1)
        text2 = view.findViewById(R.id.text2)
    }

    fun onClick(view: View) {
        TransitionManager.go(scene, transition)
        initView(scene.sceneRoot)
        text1.textSize = resources.getDimension(R.dimen.sp_60)
        text2.textSize = resources.getDimension(R.dimen.sp_48)
        val text1LayoutParams = text1.layoutParams as ConstraintLayout.LayoutParams
        val text2LayoutParams = text2.layoutParams as ConstraintLayout.LayoutParams
        text1LayoutParams.endToStart = R.id.guide_line
        text1LayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        text1LayoutParams.bottomToBottom = ConstraintLayout.LayoutParams.UNSET
        val marginTop = resources.getDimension(R.dimen.dp_120).toInt()
        text1LayoutParams.setMargins(0, marginTop, 0 , 0)
        text1.layoutParams = text1LayoutParams

        text2LayoutParams.startToEnd = R.id.guide_line
        text2LayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        text2LayoutParams.bottomToBottom = ConstraintLayout.LayoutParams.UNSET
        text2LayoutParams.setMargins(0, marginTop, 0 , 0)
        text2.layoutParams = text2LayoutParams
    }
}