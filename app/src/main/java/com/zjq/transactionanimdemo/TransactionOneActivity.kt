package com.zjq.transactionanimdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout

class TransactionOneActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction_one)
        findViewById<View>(R.id.translation).setOnClickListener { view ->
            TransitionManager.beginDelayedTransition(view.parent as ViewGroup)
            val layoutParams = view.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.width *= 2
            layoutParams.height *= 2
            view.alpha = 0.5f
            view.setBackgroundColor(android.graphics.Color.parseColor("#FF5722"))
            view.layoutParams = layoutParams
        }
    }
}