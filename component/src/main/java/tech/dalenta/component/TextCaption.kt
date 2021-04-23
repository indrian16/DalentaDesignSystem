package tech.dalenta.component

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import tech.dalenta.component.utils.*

class TextCaption(context: Context, attrs: AttributeSet?) : AppCompatTextView(context, attrs) {
    init {

        val attributes = context.obtainStyledAttributes(attrs, R.styleable.TextCaption)
        val state = attributes.getInt(R.styleable.TextCaption_caption_state, CaptionState.NEUTRAL)

        changeTextAppearance(R.style.TextAppearance_DalentaDesignSystem_Subtitle2)
        changeDrawablePadding(8)
        setCaptionState(state)

        attributes.recycle()
    }

    fun setCaptionState(captionState: Int) {

        // Set Attr
        when (captionState) {
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
}