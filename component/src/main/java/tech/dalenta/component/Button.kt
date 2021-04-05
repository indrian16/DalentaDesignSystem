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
        button.text = attributes.getString(R.styleable.Button_android_text)
//        button.width = attributes.getLayoutDimension(R.styleable.Button_android_layout_width, 0)
//        button.height = attributes.getLayoutDimension(R.styleable.Button_android_layout_height, 0)

        attributes.recycle()
    }

    override fun setOnClickListener(l: OnClickListener?) {
        button.setOnClickListener(l)
    }

}