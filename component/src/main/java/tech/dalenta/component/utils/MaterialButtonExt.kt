package tech.dalenta.component.utils

import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import tech.dalenta.component.R

fun MaterialButton.changeIcon(drawable: Drawable?) {
    icon = drawable ?: ContextCompat.getDrawable(context, R.drawable.ic_search)
}

fun MaterialButton.changeIconSize(size: Float) {
    iconSize = (size).toInt()
}