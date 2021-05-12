package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import tech.dalenta.component.utils.*

class IconSmallButtonPrimary(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    var button: MaterialButton

    init {

        // Inflating Layout
        inflate(context, R.layout.icon_small_button_primary, this)

        // Get Attr
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.IconSmallButtonPrimary)

        // Get Dimension
        val dimensionWidth = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.IconSmallButtonPrimary_android_layout_width, LayoutParams.WRAP_CONTENT))
        val dimensionHeight = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.IconSmallButtonPrimary_android_layout_height, LayoutParams.WRAP_CONTENT))
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
            changeIcon(attributes.getDrawable(R.styleable.IconSmallButtonPrimary_icon))
            changeIconSize(attributes.getDimension(R.styleable.IconSmallButtonPrimary_iconSize, iconSize.toFloat()))

            // Set Color State
            when (attributes.getInt(R.styleable.IconSmallButtonPrimary_color_state, ColorState.PRIMARY)) {
                ColorState.PRIMARY -> {
                    changeBackgroundColor(R.color.blue_3)
                }
                ColorState.GRAY -> {
                    changeBackgroundColor(R.color.grey_3)
                }
                ColorState.GREEN -> {
                    changeBackgroundColor(R.color.green_3)
                }
                ColorState.RED -> {
                    changeBackgroundColor(R.color.red_3)
                }
            }
        }

        attributes.recycle()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }
}