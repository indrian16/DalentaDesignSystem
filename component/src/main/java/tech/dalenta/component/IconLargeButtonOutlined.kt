package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import tech.dalenta.component.utils.ColorState
import tech.dalenta.component.utils.ViewUtils

class IconLargeButtonOutlined(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    var button: MaterialButton
    var parentView: FrameLayout

    init {

        // Inflating Layout
        inflate(context, R.layout.icon_large_button_outlined, this)

        // Get Attr
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.IconLargeButtonOutlined)

        // Get Dimension
        val dimensionWidth = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.IconLargeButtonOutlined_android_layout_width, LayoutParams.WRAP_CONTENT))
        val dimensionHeight = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.IconLargeButtonOutlined_android_layout_height, LayoutParams.WRAP_CONTENT))
        val params = LayoutParams(
                dimensionWidth,
                dimensionHeight
        )

        // Set Attr Child View
        button = findViewById(R.id.button)
        button.apply {

            // Set Layout Size
            layoutParams = params

            // Set Icon attribute
            icon = attributes.getDrawable(R.styleable.IconLargeButtonOutlined_icon) ?: ContextCompat.getDrawable(context, R.drawable.ic_search)

            // Set Color State
            when (attributes.getInt(R.styleable.IconLargeButtonOutlined_color_state, ColorState.PRIMARY)) {
                ColorState.PRIMARY -> {
                    changeStrokeColor(R.color.blue_3)
                    changeIconColor(R.color.blue_3)
                    changeRippleColor(R.color.blue_4)
                }
                ColorState.GRAY -> {
                    changeStrokeColor(R.color.grey_3)
                    changeIconColor(R.color.grey_3)
                    changeRippleColor(R.color.grey_4)
                }
                ColorState.GREEN -> {
                    changeStrokeColor(R.color.green_3)
                    changeIconColor(R.color.green_3)
                    changeRippleColor(R.color.green_4)
                }
                ColorState.RED -> {
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
            layoutParams.height = dimensionHeight
        }

        attributes.recycle()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }
}