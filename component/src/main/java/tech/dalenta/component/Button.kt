package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.google.android.material.button.MaterialButton

class Button(context: Context, attrs: AttributeSet) : FrameLayout(context, attrs) {

    private var button: MaterialButton

    init {
        inflate(context, R.layout.button_view, this)
        button = findViewById(R.id.button)

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.Button)
        attributes.recycle()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }

}