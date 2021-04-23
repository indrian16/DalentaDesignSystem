package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import tech.dalenta.component.utils.ViewUtils

class SelectField(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    var parentView: LinearLayout
    var textLabel: TextView
    var textInputLayout: TextInputLayout
    var textInputEditText: TextInputEditText
    var textCaptionView: TextCaption

    init {

        // Inflating Layout
        inflate(context, R.layout.select_field_view, this)

        // Bind View
        parentView = findViewById(R.id.parent_view)
        textLabel = findViewById(R.id.tv_label)
        textInputLayout = findViewById(R.id.text_input_layout)
        textInputEditText = findViewById(R.id.text_input_edit_text)
        textCaptionView = findViewById(R.id.tv_caption)

        // Get Attr
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.SelectField)

        // Get Dimension
        val dimensionWidth = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.SelectField_android_layout_width, LayoutParams.WRAP_CONTENT))
        val dimensionHeight = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.SelectField_android_layout_height, LayoutParams.WRAP_CONTENT))
        val params = LayoutParams(
                dimensionWidth,
                dimensionHeight
        )

        // Set Dimension
        parentView.layoutParams = params

        attributes.recycle()
    }
}