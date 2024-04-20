package com.zjq.transactionanimdemo

import android.content.res.Resources
import android.util.TypedValue

object DisplayUtil {
    fun dpToPx(dp: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp.toFloat(),
            Resources.getSystem().displayMetrics
        ).toInt()
    }

    fun pxToSp(resources: Resources, px: Float): Float {
        val fontScale = resources.displayMetrics.scaledDensity
        return px / fontScale + 0.5f
    }
}
