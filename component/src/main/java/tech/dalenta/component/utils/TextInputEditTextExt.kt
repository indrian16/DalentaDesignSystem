package tech.dalenta.component.utils

import android.content.res.ColorStateList
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText

fun TextInputEditText.changeTextColor(@ColorRes resId: Int) {
    setTextColor(ColorStateList.valueOf(ContextCompat.getColor(this.context, resId)))
}