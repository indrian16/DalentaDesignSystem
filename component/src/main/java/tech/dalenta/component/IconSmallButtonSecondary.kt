package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton

class IconSmallButtonSecondary(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {
    var button: MaterialButton
    var parentView: FrameLayout

    init {
        inflate(context, R.layout.icon_small_button_secondary, this)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.IconSmallButtonSecondary)

        val dimensionWidth = attributes.getLayoutDimension(R.styleable.Button_android_layout_width, LayoutParams.WRAP_CONTENT)
        val dimensionHeight = attributes.getLayoutDimension(R.styleable.Button_android_layout_height, LayoutParams.WRAP_CONTENT)

        val params = LayoutParams(
                dimensionWidth,
                dimensionHeight
        )

        button = findViewById(R.id.button)
        button.apply {
            layoutParams = params
            icon = attributes.getDrawable(R.styleable.IconSmallButtonSecondary_icon) ?: ContextCompat.getDrawable(context, R.drawable.ic_search)
        }

        parentView = findViewById(R.id.parent_view)
        if (dimensionWidth == LayoutParams.MATCH_PARENT) {
            parentView.layoutParams.width = LayoutParams.MATCH_PARENT
        }
        if (dimensionHeight == LayoutParams.MATCH_PARENT) {
            parentView.layoutParams.height = LayoutParams.MATCH_PARENT
        }

        attributes.recycle()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }
}