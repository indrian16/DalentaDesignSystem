package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.FrameLayout
import com.google.android.material.button.MaterialButton

class SmallButtonOutlined(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    var button: MaterialButton
    var parentView: FrameLayout

    init {
        inflate(context, R.layout.small_button_outlined, this)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.SmallButtonOutlined)

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
            icon = attributes.getDrawable(R.styleable.SmallButtonOutlined_icon)
            iconGravity = attributes.getInt(R.styleable.SmallButtonOutlined_iconGravity, button.iconGravity)
        }

        parentView = findViewById(R.id.parent_view)
        if (dimensionWidth == LayoutParams.MATCH_PARENT) {
            parentView.layoutParams.width = LayoutParams.MATCH_PARENT
        }
        if (dimensionHeight == LayoutParams.MATCH_PARENT) {
            parentView.layoutParams.height = LayoutParams.MATCH_PARENT
        }

        // Set Color State
        when (attributes.getInt(R.styleable.SmallButtonOutlined_color_state, ColorState.PRIMARY)) {
            ColorState.PRIMARY -> {
                button.apply {
                    changeTextColor(R.color.blue_3)
                    changeStrokeColor(R.color.blue_3)
                    changeIconColor(R.color.blue_3)
                    changeRippleColor(R.color.blue_4)
                }
            }
            ColorState.GRAY -> {
                button.apply {
                    changeTextColor(R.color.grey_3)
                    changeStrokeColor(R.color.grey_3)
                    changeIconColor(R.color.grey_3)
                    changeRippleColor(R.color.grey_4)
                }
            }
            ColorState.GREEN -> {
                button.apply {
                    changeTextColor(R.color.green_3)
                    changeStrokeColor(R.color.green_3)
                    changeIconColor(R.color.green_3)
                    changeRippleColor(R.color.green_4)
                }
            }
            ColorState.RED -> {
                button.apply {
                    changeTextColor(R.color.red_3)
                    changeStrokeColor(R.color.red_3)
                    changeIconColor(R.color.red_3)
                    changeRippleColor(R.color.red_4)
                }
            }
        }

        attributes.recycle()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }
}