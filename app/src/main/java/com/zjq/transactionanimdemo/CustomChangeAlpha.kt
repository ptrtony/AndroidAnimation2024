package com.zjq.transactionanimdemo

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.ViewGroup
import androidx.transition.Transition
import androidx.transition.TransitionValues
class CustomChangeAlpha : Transition() {
    companion object {
        private const val ALPHA_KEY = "alpha"
    }
    override fun captureStartValues(transitionValues: TransitionValues) {
        transitionValues.values[ALPHA_KEY] = transitionValues.view.alpha
    }

    override fun captureEndValues(transitionValues: TransitionValues) {
        transitionValues.values[ALPHA_KEY] = transitionValues.view.alpha
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
        val startAlpha = startValues.values[ALPHA_KEY]
        val endAlpha = endValues.values[ALPHA_KEY]
        if (startAlpha !is Float || endAlpha !is Float) {
            return null
        }
        view.alpha = startAlpha
        val animator = ObjectAnimator.ofFloat(view, "alpha", startAlpha, endAlpha)
        animator.pause()
        return animator
    }
}