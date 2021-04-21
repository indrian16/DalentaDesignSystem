package tech.dalenta.component

import android.content.Context
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.TypedValue
import android.view.inputmethod.EditorInfo
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import tech.dalenta.component.utils.*

class TextInput(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    var parentView: LinearLayout
    var textLabel: TextView
    var textInputLayout: TextInputLayout
    var textInputEditText: TextInputEditText
    var textCaptionView: TextCaption

    init {

        // Inflating Layout
        inflate(context, R.layout.text_input_view, this)

        // Get Attr
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.TextInput)

        // Get Dimension
        val dimensionWidth = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.TextInput_android_layout_width, LayoutParams.WRAP_CONTENT))
        val dimensionHeight = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.TextInput_android_layout_height, LayoutParams.WRAP_CONTENT))
        val params = LayoutParams(
                dimensionWidth,
                dimensionHeight
        )

        // Bind View
        parentView = findViewById(R.id.parent_view)
        textLabel = findViewById(R.id.tv_label)
        textInputLayout = findViewById(R.id.text_input_layout)
        textInputEditText = findViewById(R.id.text_input_edit_text)
        textCaptionView = findViewById(R.id.tv_caption)

        // Set Attr Text Label
        textLabel.apply {
            text = attributes.getString(R.styleable.TextInput_textLabel) ?: "Text Field Label"
            setTextSize(TypedValue.COMPLEX_UNIT_PX, attributes.getDimension(R.styleable.TextInput_textLabelSize, textLabel.textSize))
        }

        // Set Attr Text Input Layout
        textInputLayout.apply {
            changeEndIconDrawable(attributes.getDrawable(R.styleable.TextInput_endIconDrawable))
            changeEndIconMode(attributes.getInt(R.styleable.TextInput_endIconMode, 0))
        }

        // Set Attr Edit Text
        textInputEditText.apply {
            setText(attributes.getString(R.styleable.TextInput_android_text))
            setTextSize(TypedValue.COMPLEX_UNIT_PX, attributes.getDimension(R.styleable.TextInput_android_textSize, textInputEditText.textSize))
            hint = attributes.getString(R.styleable.TextInput_android_hint) ?: "Placeholder"
            inputType = attributes.getInt(R.styleable.TextInput_android_inputType, EditorInfo.TYPE_CLASS_TEXT)

            // Typing Style
            setOnFocusChangeListener { _, hasFocus ->
                textInputLayout.apply {

                    if (hasFocus) {
                        changeBoxBackgroundColor(R.color.blue_5)
                    } else {
                        changeBoxBackgroundColor(R.color.grey_5)
                    }

                }
            }
        }

        // Set Attr
        textCaptionView.apply {
            text = attributes.getString(R.styleable.TextInput_textCaption) ?: "Caption"
        }

        // Set Caption State
        val captionStateAttr = attributes.getInt(R.styleable.TextInput_caption_state, CaptionState.NEUTRAL)
        setCaptionState(captionStateAttr)

        // Set Dimension
        parentView.layoutParams = params

        attributes.recycle()
    }

    var text: String
        get() = textInputEditText.text.toString()
        set(value) { textInputEditText.setText(value) }

    var textCaption: String
        get() = textCaptionView.text.toString()
        set(value) { textCaptionView.text = value }

    fun setCaptionState(captionState: Int) {
        textCaptionView.captionState = captionState
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

    fun addTextChangedListener(textWatcher: TextWatcher) {
        textInputEditText.addTextChangedListener(textWatcher)
    }
}