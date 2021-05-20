package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.FrameLayout
import com.google.android.material.button.MaterialButton
import tech.dalenta.component.utils.ColorState
import tech.dalenta.component.utils.ViewUtils
import tech.dalenta.component.utils.changeBackgroundColor
import tech.dalenta.component.utils.changeTextColor

class LargeButtonPrimary(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    var button: MaterialButton
    private var colorState: Int = ColorState.PRIMARY

    init {

        // Inflating Layout
        inflate(context, R.layout.large_button_primary, this)

        // Get Attr
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.LargeButtonPrimary)

        // Get Dimension
        val dimensionWidth = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.LargeButtonPrimary_android_layout_width, LayoutParams.WRAP_CONTENT))
        val dimensionHeight = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.LargeButtonPrimary_android_layout_height, LayoutParams.WRAP_CONTENT))
        val params = LayoutParams(
                dimensionWidth,
                dimensionHeight
        )

        // Set Attr Child View
        button = findViewById(R.id.button)
        button.apply {

            // Set Text attribute
            text = attributes.getString(R.styleable.LargeButtonPrimary_android_text) ?: "Button"
            setTextSize(TypedValue.COMPLEX_UNIT_PX, attributes.getDimension(R.styleable.LargeButtonPrimary_android_textSize, this.textSize))

            // Set Layout Size
            layoutParams = params

            // Set Icon attribute
            icon = attributes.getDrawable(R.styleable.LargeButtonPrimary_icon)
            iconGravity = attributes.getInt(R.styleable.LargeButtonPrimary_iconGravity, button.iconGravity)

            // Set Color State
            colorState = attributes.getInt(R.styleable.LargeButtonPrimary_color_state, ColorState.PRIMARY)

            // Set isEnabled
            this@LargeButtonPrimary.isEnabled = attributes.getBoolean(R.styleable.LargeButtonPrimary_android_enabled, true)
        }

        attributes.recycle()
    }

    override fun isEnabled(): Boolean = button.isEnabled

    override fun setEnabled(enabled: Boolean) {
        button.isEnabled = enabled

        // Set Color State Color
        setColorState(colorState)
    }

    private fun setColorState(colorState: Int) {
        with(button) {
            changeTextColor(R.color.white)
            when (colorState) {
                ColorState.PRIMARY -> {
                    if (isEnabled) {
                        changeBackgroundColor(R.color.blue_3)
                    } else {
                        changeBackgroundColor(R.color.blue_4)
                    }
                }
                ColorState.GRAY -> {
                    if (isEnabled) {
                        changeBackgroundColor(R.color.grey_3)
                    } else {
                        changeBackgroundColor(R.color.grey_4)
                    }
                }
                ColorState.GREEN -> {
                    if (isEnabled) {
                        changeBackgroundColor(R.color.green_3)
                    } else {
                        changeBackgroundColor(R.color.green_4)
                    }
                }
                ColorState.RED -> {
                    if (isEnabled) {
                        changeBackgroundColor(R.color.red_3)
                    } else {
                        changeBackgroundColor(R.color.red_4)
                    }
                }
            }
        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }
}