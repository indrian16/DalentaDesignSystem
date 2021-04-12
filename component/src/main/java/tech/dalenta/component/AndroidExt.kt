package tech.dalenta.component

import android.content.Context
import android.os.Build
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.radiobutton.MaterialRadioButton

fun MaterialRadioButton.setAppearance(context: Context, res: Int) {
    if (Build.VERSION.SDK_INT < 23) {
        setTextAppearance(context, res)
    } else {
        setTextAppearance(res)
    }
}

fun MaterialButton.changeBackgroundColor(resId: Int) {
    backgroundTintList = ContextCompat.getColorStateList(this.context, resId)
}

fun MaterialButton.changeTextColor(resId: Int) {
    setTextColor(ContextCompat.getColorStateList(this.context, resId))
}

fun MaterialButton.changeRippleColor(resId: Int) {
    rippleColor = ContextCompat.getColorStateList(this.context, resId)
}

fun MaterialButton.changeStrokeColor(resId: Int) {
    strokeColor = ContextCompat.getColorStateList(this.context, resId)
}

fun MaterialButton.changeIconColor(resId: Int) {
    iconTint = ContextCompat.getColorStateList(this.context, resId)
}