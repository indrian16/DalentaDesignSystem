package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.radiobutton.MaterialRadioButton

class Radio constructor(
        context: Context,
        attrs: AttributeSet?,
) : MaterialRadioButton(context, attrs)
{
    init {
        setAppearance(context, R.style.TextAppearance_AppCompat_Body2)
        setTextColor(ContextCompat.getColorStateList(getContext(), R.color.dark));
    }
}