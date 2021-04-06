package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import android.view.inputmethod.EditorInfo
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class TextField(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    var parentView: LinearLayout
    var textLabel: TextView
    var textInputLayout: TextInputLayout
    var textInputEditText: TextInputEditText

    init {
        inflate(context, R.layout.text_field_view, this)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.TextField)

        parentView = findViewById(R.id.parent_view)
        textLabel = findViewById(R.id.tv_label)
        textInputLayout = findViewById(R.id.text_input_layout)
        textInputEditText = findViewById(R.id.text_input_edit_text)

        textLabel.apply {
            text = attributes.getString(R.styleable.TextField_textLabel) ?: "Text Field Label"
        }
        textInputEditText.apply {
            setText(attributes.getString(R.styleable.TextField_android_text))
            hint = attributes.getString(R.styleable.TextField_android_hint) ?: "Placeholder"
            inputType = attributes.getInt(R.styleable.TextField_android_inputType, EditorInfo.TYPE_CLASS_TEXT)
        }

        attributes.recycle()
    }
}