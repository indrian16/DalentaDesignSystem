package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import tech.dalenta.component.utils.*

class TextCaption(context: Context, private val attrs: AttributeSet?) : AppCompatTextView(context, attrs) {

    var captionState: Int
        get() {
            val attributes = context.obtainStyledAttributes(attrs, R.styleable.TextCaption)
            val state = attributes.getInt(R.styleable.TextInput_caption_state, CaptionState.NEUTRAL)
            attributes.recycle()

            return state
        }
        set(value) {
            // Set Attr
            when (value) {
                CaptionState.NEUTRAL -> {
                    toVisible()

                    leftCompoundDrawables(R.drawable.ic_info)
                    changeTextColor(R.color.grey_2)
                    changeCompoundDrawableColor(R.color.grey_2)
                }
                CaptionState.WARING -> {
                    toVisible()

                    leftCompoundDrawables(R.drawable.ic_info)
                    changeTextColor(R.color.orange_2)
                    changeCompoundDrawableColor(R.color.orange_2)
                }
                CaptionState.SUCCESS -> {
                    toVisible()

                    leftCompoundDrawables(R.drawable.ic_success)
                    changeTextColor(R.color.green_2)
                    changeCompoundDrawableColor(R.color.green_2)
                }
                CaptionState.ERROR -> {
                    toVisible()

                    leftCompoundDrawables(R.drawable.ic_error)
                    changeTextColor(R.color.red_2)
                    changeCompoundDrawableColor(R.color.red_2)
                }
                CaptionState.NONE -> {
                    toInvisible()
                }
            }
        }

    init {

        changeTextAppearance(R.style.TextAppearance_DalentaDesignSystem_Subtitle2)
        changeDrawablePadding(8)
        this.captionState = CaptionState.NEUTRAL
    }
}