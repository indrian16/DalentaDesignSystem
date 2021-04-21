package tech.dalenta.component.utils

import android.R
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputLayout

fun TextInputLayout.changeEndIconDrawable(drawable: Drawable?) {
    if (drawable != null) {
        endIconDrawable = drawable
    }
}

fun TextInputLayout.changeEndIconMode(mode: Int?) {
    endIconMode = mode ?: 0 // Default None Mode
}

fun TextInputLayout.changeBoxBackgroundColor(@ColorRes resId: Int) {
    boxBackgroundColor = ContextCompat.getColor(context, resId)
}

fun TextInputLayout.changeBoxStrokeColorStateList(@ColorRes resId: Int) {
    val states = arrayOf(
            intArrayOf(R.attr.state_hovered),
            intArrayOf(-R.attr.state_enabled),
            intArrayOf()
    )

    val color: Int = ContextCompat.getColor(context, resId)
    val colors = intArrayOf(
            color,
            color,
            color,
    )

    setBoxStrokeColorStateList(ColorStateList(states, colors))
}

fun TextInputLayout.changeBoxStrokeWidth(size: Int) {
    boxStrokeWidth = size.dp
}