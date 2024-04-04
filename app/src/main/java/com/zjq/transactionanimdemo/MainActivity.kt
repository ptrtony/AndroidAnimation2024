package com.zjq.transactionanimdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onTransactionClickOne(view: View) {
        startActivity(Intent(this, TransactionOneActivity::class.java))
    }

    fun onTransactionClickTwo(view: View) {
        startActivity(Intent(this, TransactionTwoActivity::class.java))
    }

    fun onAnimationClickOne(view: View) {
        startActivity(Intent(this, ComposeAnimationOneActivity::class.java))
    }

    fun onAnimationClickTwo(view: View) {
        startActivity(Intent(this, ComposeAnimationTwoActivity::class.java))
    }

    fun onAnimationClickThree(view: View) {
        startActivity(Intent(this, ComposeAnimationThreeActivity::class.java))
    }

    fun onAnimationClickFour(view: View) {
        startActivity(Intent(this, ComposeAnimationFourActivity::class.java))
    }

    fun onAnimationClickFive(view: View) {
        startActivity(Intent(this, ComposeAnimationFiveActivity::class.java))
    }

    fun onAnimationClickSix(view: View) {
        startActivity(Intent(this, SceneDemoOneActivity::class.java))
    }

    fun onAnimationClickSeven(view: View) {
        startActivity(Intent(this, SceneDemoTwoActivity::class.java))
    }
}
