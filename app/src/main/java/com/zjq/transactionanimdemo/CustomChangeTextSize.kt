package com.zjq.transactionanimdemo

import android.animation.Animator
import android.animation.ValueAnimator
import android.animation.ValueAnimator.AnimatorUpdateListener
import android.transition.Transition
import android.transition.TransitionValues
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.TextView

class CustomChangeTextSize :  Transition() {

    companion object {
        private const val TEXT_SIZE_KEY = "text_size"
    }

    override fun captureStartValues(transitionValues: TransitionValues?) {
        captureValues(transitionValues)
    }

    override fun captureEndValues(transitionValues: TransitionValues?) {
        captureValues(transitionValues)
    }

    private fun captureValues(transitionValues: TransitionValues?) {
        if (transitionValues == null) {
            return
        }
        if (transitionValues.view !is TextView) {
            return
        }
        transitionValues.values[TEXT_SIZE_KEY] = (transitionValues.view as TextView).textSize
    }


    override fun createAnimator(
        sceneRoot: ViewGroup?,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator? {
        if (startValues == null || endValues == null) {
            return null
        }
        val view = endValues.view
        if (view !is TextView) {
            return null
        }
        var startTextSize = startValues.values[TEXT_SIZE_KEY]
        var endTextSize = endValues.values[TEXT_SIZE_KEY]
        if (startTextSize !is Float && endTextSize !is Float) {
            return null
        }
//        startTextSize = DisplayUtil.pxToSp(view.resources, startTextSize as Float)
//        endTextSize = DisplayUtil.pxToSp(view.resources, endTextSize as Float)
//        val dis = abs((startTextSize as Float) - (endTextSize as Float))
//        val textSizeFrame1 = Keyframe.ofFloat(0f, startTextSize)
//        val textSizeFrame2 = Keyframe.ofFloat(0.1f, 0.1f * dis + startTextSize)
//        val textSizeFrame3= Keyframe.ofFloat(0.2f, 0.2f * dis + startTextSize)
//        val textSizeFrame4 = Keyframe.ofFloat(0.3f, 0.3f * dis + startTextSize)
//        val textSizeFrame5 = Keyframe.ofFloat(0.4f, 0.4f * dis + startTextSize)
//        val textSizeFrame6 = Keyframe.ofFloat(0.5f, 0.5f * dis + startTextSize)
//        val textSizeFrame7 = Keyframe.ofFloat(0.6f, 0.6f * dis + startTextSize)
//        val textSizeFrame8 = Keyframe.ofFloat(0.7f, 0.7f * dis + startTextSize)
//        val textSizeFrame9 = Keyframe.ofFloat(0.8f, 0.8f * dis + startTextSize)
//        val textSizeFrame10 = Keyframe.ofFloat(0.9f, 0.9f * dis + startTextSize)
//        val textSizeFrame11 = Keyframe.ofFloat(1.0f, endTextSize)
//        val valueHolder = PropertyValuesHolder.ofKeyframe(
//            "textSize",
//            textSizeFrame1,
//            textSizeFrame2,
//            textSizeFrame3,
//            textSizeFrame4,
//            textSizeFrame5,
//            textSizeFrame6,
//            textSizeFrame7,
//            textSizeFrame8,
//            textSizeFrame9,
//            textSizeFrame10,
//            textSizeFrame11
//        )
        val animator = ValueAnimator.ofFloat(startTextSize as Float, endTextSize as Float)
        val listener = AnimatorUpdateListener { p0 ->
            val animationValue = p0.animatedValue as Float
            view.setTextSize(TypedValue.COMPLEX_UNIT_PX, animationValue)
        }
        animator.addUpdateListener(listener)
        animator.pause()
        view.setTextSize(TypedValue.COMPLEX_UNIT_PX, startTextSize as Float)
        return animator
    }
}