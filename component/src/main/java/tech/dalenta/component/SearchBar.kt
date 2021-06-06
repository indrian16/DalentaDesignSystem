package tech.dalenta.component

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.TypedValue
import android.view.inputmethod.EditorInfo
import android.widget.FrameLayout
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import tech.dalenta.component.listener.WatchTextListener
import tech.dalenta.component.utils.*

class SearchBar(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    var parentView: FrameLayout
    var textInputLayout: TextInputLayout
    var textInputEditText: TextInputEditText

    init {

        // Inflating Layout
        inflate(context, R.layout.search_bar_view, this)

        // Bind View
        parentView = findViewById(R.id.parent_view)
        textInputLayout = findViewById(R.id.text_input_layout)
        textInputEditText = findViewById(R.id.text_input_edit_text)

        // Get Attr
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.SearchBar)

        // Get Dimension
        val dimensionWidth = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.SearchBar_android_layout_width, LayoutParams.WRAP_CONTENT))
        val dimensionHeight = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.SearchBar_android_layout_height, LayoutParams.WRAP_CONTENT))
        val params = LayoutParams(
                dimensionWidth,
                dimensionHeight
        )

        // Set Attr Edit Text
        textInputEditText.apply {

            setText(attributes.getString(R.styleable.SearchBar_android_text))
            setTextSize(TypedValue.COMPLEX_UNIT_PX, attributes.getDimension(R.styleable.SearchBar_android_textSize, textInputEditText.textSize))
            hint = attributes.getString(R.styleable.SearchBar_android_hint) ?: "Placeholder"
            inputType = attributes.getInt(R.styleable.SearchBar_android_inputType, EditorInfo.TYPE_CLASS_TEXT)

            // Typing Style
            setOnFocusChangeListener { _, hasFocus ->
                textInputLayout.apply {

                    if (hasFocus) {
                        changeStartIconTintList(R.color.blue_3)
                        changeBoxBackgroundColor(R.color.blue_5)
                    } else {
                        changeStartIconTintList(R.color.grey_3)
                        changeBoxBackgroundColor(R.color.grey_5)
                    }

                }
            }
        }

        // Set Dimension
        parentView.layoutParams = params

        attributes.recycle()
    }

    fun addTextChangedListener(textWatcher: TextWatcher) {
        textInputEditText.addTextChangedListener(textWatcher)
    }

    fun watchTextChange(watchTextListener: WatchTextListener) {
        textInputEditText.addTextChangedListener(
                object : TextWatcher {
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        if (s != null) {
                            watchTextListener.onTextChanged(s.toString(), start, before, count)
                        }
                    }
                    override fun afterTextChanged(s: Editable?) {}
                }
        )
    }
}