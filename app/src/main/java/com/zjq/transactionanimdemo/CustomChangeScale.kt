package com.zjq.transactionanimdemo

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.ViewGroup
import androidx.transition.Transition
import androidx.transition.TransitionValues

class CustomChangeScale : Transition() {
    companion object {
        private const val SCALE_X_KEY = "com.company.name.scale_x"
        private const val SCALE_Y_KEY = "com.company.name.scale_y"
    }
    override fun captureStartValues(transitionValues: TransitionValues) {
       captureValues(transitionValues)
    }

    override fun captureEndValues(transitionValues: TransitionValues) {
        captureValues(transitionValues)
    }

    private fun captureValues(transitionValues: TransitionValues) {
        transitionValues.values[SCALE_X_KEY] = transitionValues.view.scaleX
        transitionValues.values[SCALE_Y_KEY] = transitionValues.view.scaleY
    }

    override fun createAnimator(
        sceneRoot: ViewGroup,
        startValues: TransitionValues?,
        endValues: TransitionValues?
    ): Animator? {
        if (startValues == null || endValues == null) {
            return null
        }
        val view = endValues.view ?: return null
        val startScaleX = startValues.values[SCALE_X_KEY]
        val startScaleY = startValues.values[SCALE_Y_KEY]
        val endScaleX = endValues.values[SCALE_X_KEY]
        val endScaleY = endValues.values[SCALE_Y_KEY]
        if (startScaleX == endScaleX && startScaleY == endScaleY) {
            return null
        }
        if (startScaleX !is Float || startScaleY !is Float ||
                endScaleX !is Float || endScaleY !is Float) {
            return null
        }
        val scaleXAnimator = ObjectAnimator.ofFloat(view, "scaleX", startScaleX, endScaleX)
        val scaleYAnimator = ObjectAnimator.ofFloat(view, "scaleY", startScaleY, endScaleY)
        val animatorSet = AnimatorSet()
        animatorSet.playTogether(scaleXAnimator, scaleYAnimator)
        view.scaleX = startScaleX
        view.scaleY = startScaleY
        return animatorSet
    }
}