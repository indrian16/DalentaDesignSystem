package tech.dalenta.component

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.NumberPicker
import tech.dalenta.component.utils.ViewUtils
import tech.dalenta.component.utils.dp
import tech.dalenta.component.utils.setDividerHeight

class DatePicker(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    var parentView: LinearLayout
    var pickerDay: NumberPicker
    var pickerMonth: NumberPicker
    var pickerYear: NumberPicker

    init {

        // Inflating Layout
        inflate(context, R.layout.date_picker, this)

        // Bind View
        parentView = findViewById(R.id.parent_view)
        pickerDay = findViewById(R.id.picker_day)
        pickerMonth = findViewById(R.id.picker_month)
        pickerYear = findViewById(R.id.picker_year)

        // Get Attr
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.DatePicker)

        // Get Dimension
        val dimensionWidth = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.DatePicker_android_layout_width, LayoutParams.WRAP_CONTENT))
        val dimensionHeight = ViewUtils.getOverflowDimension(attributes.getLayoutDimension(R.styleable.DatePicker_android_layout_height, LayoutParams.WRAP_CONTENT))
        val params = LayoutParams(
            dimensionWidth,
            dimensionHeight
        )

        // Set Size Divider
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            pickerDay.selectionDividerHeight = 1.dp
            pickerMonth.selectionDividerHeight = 1.dp
            pickerYear.selectionDividerHeight = 1.dp
        } else {
            pickerDay.setDividerHeight(1.dp)
            pickerMonth.setDividerHeight(1.dp)
            pickerYear.setDividerHeight(1.dp)
        }

        // Set Dimension
        parentView.layoutParams = params

        attributes.recycle()
    }
}