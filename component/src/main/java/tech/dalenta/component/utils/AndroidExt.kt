package tech.dalenta.component.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Build
import android.view.View
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.radiobutton.MaterialRadioButton

fun View.toVisible() {
    visibility = View.VISIBLE
}

fun View.toGone() {
    visibility = View.GONE
}

fun View.toInvisible() {
    visibility = View.INVISIBLE
}

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

val Float.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

fun MaterialRadioButton.setAppearance(context: Context, res: Int) {
    if (Build.VERSION.SDK_INT < 23) {
        setTextAppearance(context, res)
    } else {
        setTextAppearance(res)
    }
}

fun AppCompatTextView.changeTextAppearance(resId: Int) {
    if (Build.VERSION.SDK_INT < 23) {
        setTextAppearance(context, resId)
    } else {
        setTextAppearance(resId)
    }
}

fun AppCompatTextView.changeTextColor(@ColorRes resId: Int) {
    setTextColor(ContextCompat.getColorStateList(this.context, resId))
}

fun AppCompatTextView.leftCompoundDrawables(@DrawableRes resId: Int) {
    val drawable = ContextCompat.getDrawable(context, resId)
    val size = 14.dp
    drawable?.setBounds(0, 0, size, size)
    this.setCompoundDrawables(drawable, null, null, null)
}

fun AppCompatTextView.changeCompoundDrawableColor(@ColorRes resId: Int) {
    for (drawable in compoundDrawables) {
        if (drawable != null) {
            drawable.colorFilter = PorterDuffColorFilter(ContextCompat.getColor(context, resId), PorterDuff.Mode.SRC_IN)
        }
    }
}


fun AppCompatTextView.changeDrawablePadding(size: Int) {
    compoundDrawablePadding = size.dp
}

fun MaterialButton.changeBackgroundColor(@ColorRes resId: Int) {
    backgroundTintList = ContextCompat.getColorStateList(this.context, resId)
}

fun MaterialButton.changeTextColor(@ColorRes resId: Int) {
    setTextColor(ContextCompat.getColorStateList(this.context, resId))
}

fun MaterialButton.changeRippleColor(@ColorRes resId: Int) {
    rippleColor = ContextCompat.getColorStateList(this.context, resId)
}

fun MaterialButton.changeStrokeColor(@ColorRes resId: Int) {
    strokeColor = ContextCompat.getColorStateList(this.context, resId)
}

fun MaterialButton.changeIconColor(@ColorRes resId: Int) {
    iconTint = ContextCompat.getColorStateList(this.context, resId)
}