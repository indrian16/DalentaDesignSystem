package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.FrameLayout
import com.google.android.material.button.MaterialButton
import tech.dalenta.component.utils.*

class LargeButtonSecondary(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    var button: MaterialButton

    init {

        // Inflating Layout
        inflate(context, R.layout.large_button_secondary, this)

        // Get Attr
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.LargeButtonSecondary)

        // Get Dimension
        val dimensionWidth = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.LargeButtonSecondary_android_layout_width, LayoutParams.WRAP_CONTENT))
        val dimensionHeight = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.LargeButtonSecondary_android_layout_height, LayoutParams.WRAP_CONTENT))
        val params = LayoutParams(
                dimensionWidth,
                dimensionHeight
        )

        // Set Attr Child View
        button = findViewById(R.id.button)
        button.apply {

            // Set Text attribute
            text = attributes.getString(R.styleable.LargeButtonSecondary_android_text) ?: "Button"
            setTextSize(TypedValue.COMPLEX_UNIT_PX, attributes.getDimension(R.styleable.LargeButtonSecondary_android_textSize, this.textSize))

            // Set Layout Size
            layoutParams = params

            // Set Icon attribute
            icon = attributes.getDrawable(R.styleable.LargeButtonSecondary_icon)
            iconGravity = attributes.getInt(R.styleable.LargeButtonSecondary_iconGravity, button.iconGravity)

            // Set Color State
            when (attributes.getInt(R.styleable.LargeButtonSecondary_color_state, ColorState.PRIMARY)) {
                ColorState.PRIMARY -> {
                    changeBackgroundColor(R.color.blue_5)
                    changeRippleColor(R.color.blue_4)
                    changeTextColor(R.color.blue_3)
                    changeIconColor(R.color.blue_3)
                }
                ColorState.GRAY -> {
                    changeBackgroundColor(R.color.grey_5)
                    changeRippleColor(R.color.grey_4)
                    changeTextColor(R.color.grey_3)
                    changeIconColor(R.color.grey_3)
                }
                ColorState.GREEN -> {
                    changeBackgroundColor(R.color.green_5)
                    changeRippleColor(R.color.green_4)
                    changeTextColor(R.color.green_3)
                    changeIconColor(R.color.green_3)
                }
                ColorState.RED -> {
                    changeBackgroundColor(R.color.red_5)
                    changeRippleColor(R.color.red_4)
                    changeTextColor(R.color.red_3)
                    changeIconColor(R.color.red_3)
                }
            }
        }

        attributes.recycle()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }

}