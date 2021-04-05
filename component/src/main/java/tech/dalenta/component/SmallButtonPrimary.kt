package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.google.android.material.button.MaterialButton

class SmallButtonPrimary(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    var button: MaterialButton

    init {
        inflate(context, R.layout.small_button_primary, this)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.SmallButtonPrimary)
        val params = LayoutParams(
            attributes.getLayoutDimension(R.styleable.Button_android_layout_width, LayoutParams.WRAP_CONTENT),
            attributes.getLayoutDimension(R.styleable.Button_android_layout_height, LayoutParams.WRAP_CONTENT)
        )

        button = findViewById(R.id.button)
        button.apply {
            text = attributes.getString(R.styleable.Button_android_text) ?: "Button"
            layoutParams = params
        }

        attributes.recycle()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }
}