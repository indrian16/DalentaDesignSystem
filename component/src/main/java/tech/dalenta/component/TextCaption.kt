package tech.dalenta.component

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import tech.dalenta.component.utils.CaptionState

@SuppressLint("SetTextI18n")
class TextCaption(context: Context, private val attrs: AttributeSet?) : AppCompatTextView(context, attrs) {

    init {

        changeTextAppearance(R.style.TextAppearance_DalentaDesignSystem_Subtitle2)
        changeDrawablePadding(8)
        setCaptionState(CaptionState.NEUTRAL)
    }

    fun setCaptionState(captionState: Int) {
        // Get Attr
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.TextCaption)

        // Set Attr
        when (attributes.getInt(R.styleable.TextCaption_caption_state, captionState)) {
            CaptionState.NEUTRAL -> {
                leftCompoundDrawables(R.drawable.ic_info, R.dimen.icon_size)
                changeTextColor(R.color.grey_2)
                changeCompoundDrawableColor(R.color.grey_2)
            }
            CaptionState.WARING -> {
                leftCompoundDrawables(R.drawable.ic_info, R.dimen.icon_size)
                changeTextColor(R.color.orange_2)
                changeCompoundDrawableColor(R.color.orange_2)
            }
            CaptionState.SUCCESS -> {
                leftCompoundDrawables(R.drawable.ic_success, R.dimen.icon_size)
                changeTextColor(R.color.green_2)
                changeCompoundDrawableColor(R.color.green_2)
            }
            CaptionState.ERROR -> {
                leftCompoundDrawables(R.drawable.ic_error, R.dimen.icon_size)
                changeTextColor(R.color.red_2)
                changeCompoundDrawableColor(R.color.red_2)
            }
            CaptionState.NONE -> {
                toGone()
            }
        }

        attributes.recycle()
    }
}