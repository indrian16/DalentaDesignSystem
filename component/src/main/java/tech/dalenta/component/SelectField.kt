package tech.dalenta.component

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import tech.dalenta.component.utils.*

class SelectField(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    var parentView: LinearLayout
    var textLabel: TextView
    var textInputLayout: TextInputLayout
    var textInputEditText: TextInputEditText
    var textCaptionView: TextCaption

    var defaultValue = "Select choices"

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

        // Set Attr Text Input Layout
        textInputLayout.apply {
            changeEndIconDrawable(attributes.getDrawable(R.styleable.SelectField_endIconDrawable), R.color.blue_3)
        }

        // Set Attr Edit Text
        textInputEditText.apply {
            defaultValue = attributes.getString(R.styleable.SelectField_defaultValue) ?: defaultValue
            val selectValue: String? = attributes.getString(R.styleable.SelectField_selectValue)
            setSelectValue(selectValue)

            setTextSize(TypedValue.COMPLEX_UNIT_PX, attributes.getDimension(R.styleable.SelectField_android_textSize, textInputEditText.textSize))
        }

        // Set Attr Caption
        textCaptionView.apply {
            text = attributes.getString(R.styleable.SelectField_textCaption) ?: "Caption"
        }

        // Set Caption State
        val captionStateAttr = attributes.getInt(R.styleable.SelectField_caption_state, CaptionState.NONE)
        setCaptionState(captionStateAttr)

        attributes.recycle()
    }

    fun setSelectValue(value: String?) {
        textInputEditText.apply {
            if (value.isNullOrEmpty()) {
                changeTextColor(R.color.blue_3)
                setText(defaultValue)
            } else {
                changeTextColor(R.color.dark)
                setText(value)
            }
        }
    }

    var textCaption: String
        get() = textCaptionView.text.toString()
        set(value) { textCaptionView.text = value }

    fun setCaptionState(captionState: Int) {
        textCaptionView.setCaptionState(captionState)
        textInputLayout.apply {
            when (captionState) {
                CaptionState.NEUTRAL -> {
                    changeBoxStrokeColorStateList(R.color.grey_5)
                }
                CaptionState.WARING -> {
                    changeBoxStrokeColorStateList(R.color.orange_3)
                }
                CaptionState.SUCCESS -> {
                    changeBoxStrokeColorStateList(R.color.green_3)
                }
                CaptionState.ERROR -> {
                    changeBoxStrokeColorStateList(R.color.red_3)
                }
                CaptionState.NONE -> {
                    changeBoxStrokeColorStateList(R.color.grey_5)
                }
            }
        }
    }

    override fun setOnClickListener(l: OnClickListener?) {
        textInputEditText.setOnClickListener(l)
    }
}