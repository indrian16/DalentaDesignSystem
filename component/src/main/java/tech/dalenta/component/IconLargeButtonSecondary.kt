package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import tech.dalenta.component.utils.*

class IconLargeButtonSecondary(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    var button: MaterialButton

    init {

        // Inflating Layout
        inflate(context, R.layout.icon_large_button_secondary, this)

        // Get Attr
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.IconLargeButtonSecondary)

        // Get Dimension
        val dimensionWidth = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.IconLargeButtonSecondary_android_layout_width, LayoutParams.WRAP_CONTENT))
        val dimensionHeight = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.IconLargeButtonSecondary_android_layout_height, LayoutParams.WRAP_CONTENT))
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
            icon = attributes.getDrawable(R.styleable.IconLargeButtonSecondary_icon) ?: ContextCompat.getDrawable(context, R.drawable.ic_search)

            // Set Color State
            when (attributes.getInt(R.styleable.IconLargeButtonSecondary_color_state, ColorState.PRIMARY)) {
                ColorState.PRIMARY -> {
                    changeBackgroundColor(R.color.blue_5)
                    changeRippleColor(R.color.blue_4)
                    changeIconColor(R.color.blue_3)
                }
                ColorState.GRAY -> {
                    changeBackgroundColor(R.color.grey_5)
                    changeRippleColor(R.color.grey_4)
                    changeIconColor(R.color.grey_3)
                }
                ColorState.GREEN -> {
                    changeBackgroundColor(R.color.green_5)
                    changeRippleColor(R.color.green_4)
                    changeIconColor(R.color.green_3)
                }
                ColorState.RED -> {
                    changeBackgroundColor(R.color.red_5)
                    changeRippleColor(R.color.red_4)
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