package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.FrameLayout
import com.google.android.material.button.MaterialButton
import tech.dalenta.component.utils.ColorState
import tech.dalenta.component.utils.ViewUtils

class SmallButtonOutlined(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    var button: MaterialButton
    var parentView: FrameLayout

    init {

        // Inflating Layout
        inflate(context, R.layout.small_button_outlined, this)

        // Get Attr
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.SmallButtonOutlined)

        // Get Dimension
        val dimensionWidth = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.Button_android_layout_width, LayoutParams.WRAP_CONTENT))
        val dimensionHeight = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.Button_android_layout_height, LayoutParams.WRAP_CONTENT))
        val params = LayoutParams(
                dimensionWidth,
                dimensionHeight
        )

        // Set Attr Child View
        button = findViewById(R.id.button)
        button.apply {

            // Set Text attribute
            text = attributes.getString(R.styleable.Button_android_text) ?: "Button"
            setTextSize(TypedValue.COMPLEX_UNIT_PX, attributes.getDimension(R.styleable.Button_android_textSize, this.textSize))

            // Set Layout Size
            layoutParams = params

            // Set Icon attribute
            icon = attributes.getDrawable(R.styleable.SmallButtonOutlined_icon)
            iconGravity = attributes.getInt(R.styleable.SmallButtonOutlined_iconGravity, button.iconGravity)

            // Set Color State
            when (attributes.getInt(R.styleable.SmallButtonOutlined_color_state, ColorState.PRIMARY)) {
                ColorState.PRIMARY -> {
                    changeTextColor(R.color.blue_3)
                    changeStrokeColor(R.color.blue_3)
                    changeIconColor(R.color.blue_3)
                    changeRippleColor(R.color.blue_4)
                }
                ColorState.GRAY -> {
                    changeTextColor(R.color.grey_3)
                    changeStrokeColor(R.color.grey_3)
                    changeIconColor(R.color.grey_3)
                    changeRippleColor(R.color.grey_4)
                }
                ColorState.GREEN -> {
                    changeTextColor(R.color.green_3)
                    changeStrokeColor(R.color.green_3)
                    changeIconColor(R.color.green_3)
                    changeRippleColor(R.color.green_4)
                }
                ColorState.RED -> {
                    changeTextColor(R.color.red_3)
                    changeStrokeColor(R.color.red_3)
                    changeIconColor(R.color.red_3)
                    changeRippleColor(R.color.red_4)
                }
            }
        }

        // Set Dimension Parent View
        parentView = findViewById(R.id.parent_view)
        parentView.apply {
            layoutParams.width = dimensionWidth
            parentView.layoutParams.height = dimensionHeight
        }

        attributes.recycle()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }
}