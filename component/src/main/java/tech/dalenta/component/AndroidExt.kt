package tech.dalenta.component

import android.content.Context
import android.os.Build
import android.widget.TextView
import com.google.android.material.radiobutton.MaterialRadioButton

fun MaterialRadioButton.setAppearance(context: Context, res: Int) {
    if (Build.VERSION.SDK_INT < 23) {
        setTextAppearance(context, res)
    } else {
        setTextAppearance(res)
    }
}