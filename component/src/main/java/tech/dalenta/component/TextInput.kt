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
import tech.dalenta.component.utils.CaptionState

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

        // Set Attr Edit Text
        textInputEditText.apply {
            setText(attributes.getString(R.styleable.TextInput_android_text))
            setTextSize(TypedValue.COMPLEX_UNIT_PX, attributes.getDimension(R.styleable.TextInput_android_textSize, textInputEditText.textSize))
            hint = attributes.getString(R.styleable.TextInput_android_hint) ?: "Placeholder"
            inputType = attributes.getInt(R.styleable.TextInput_android_inputType, EditorInfo.TYPE_CLASS_TEXT)
        }

        // Set Attr
        textCaptionView.apply {
            text = attributes.getString(R.styleable.TextInput_textCaption) ?: "Caption"
            captionState = attributes.getInt(R.styleable.TextInput_caption_state, CaptionState.NONE)
        }

        attributes.recycle()
    }

    var textCaption: String
        get() = textCaptionView.text.toString()
        set(value) { textCaptionView.text = value }

    var captionState: Int
        get() = textCaptionView.captionState
        set(value) { textCaptionView.captionState = value }

    fun addTextChangedListener(textWatcher: TextWatcher) {
        textInputEditText.addTextChangedListener(textWatcher)
    }
}