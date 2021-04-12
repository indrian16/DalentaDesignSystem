package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.FrameLayout
import com.google.android.material.button.MaterialButton

class SmallButtonSecondary(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    var button: MaterialButton
    var parentView: FrameLayout

    init {
        inflate(context, R.layout.small_button_secondary, this)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.SmallButtonSecondary)
        val dimensionWidth = attributes.getLayoutDimension(R.styleable.Button_android_layout_width, LayoutParams.WRAP_CONTENT)
        val dimensionHeight = attributes.getLayoutDimension(R.styleable.Button_android_layout_height, LayoutParams.WRAP_CONTENT)

        val params = LayoutParams(
                dimensionWidth,
                dimensionHeight
        )

        button = findViewById(R.id.button)
        button.apply {
            text = attributes.getString(R.styleable.Button_android_text) ?: "Button"
            layoutParams = params
            setTextSize(TypedValue.COMPLEX_UNIT_PX, attributes.getDimension(R.styleable.Button_android_textSize, this.textSize))
            icon = attributes.getDrawable(R.styleable.SmallButtonSecondary_icon)
            iconGravity = attributes.getInt(R.styleable.SmallButtonSecondary_iconGravity, button.iconGravity)
        }

        parentView = findViewById(R.id.parent_view)
        if (dimensionWidth == LayoutParams.MATCH_PARENT) {
            parentView.layoutParams.width = LayoutParams.MATCH_PARENT
        }
        if (dimensionHeight == LayoutParams.MATCH_PARENT) {
            parentView.layoutParams.height = LayoutParams.MATCH_PARENT
        }

        // Set Color State
        when (attributes.getInt(R.styleable.SmallButtonPrimary_color_state, ColorState.PRIMARY)) {
            ColorState.PRIMARY -> {
                button.apply {
                    changeBackgroundColor(R.color.blue_5)
                    changeRippleColor(R.color.blue_4)
                    changeTextColor(R.color.blue_3)
                    changeIconColor(R.color.blue_3)
                }
            }
            ColorState.GRAY -> {
                button.apply {
                    changeBackgroundColor(R.color.grey_5)
                    changeRippleColor(R.color.grey_4)
                    changeTextColor(R.color.grey_3)
                    changeIconColor(R.color.grey_3)
                }
            }
            ColorState.GREEN -> {
                button.apply {
                    changeBackgroundColor(R.color.green_5)
                    changeRippleColor(R.color.green_4)
                    changeTextColor(R.color.green_3)
                    changeIconColor(R.color.green_3)
                }
            }
            ColorState.RED -> {
                button.apply {
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