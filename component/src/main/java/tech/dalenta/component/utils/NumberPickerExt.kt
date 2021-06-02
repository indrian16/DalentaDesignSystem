package tech.dalenta.component.utils

import android.content.res.Resources
import android.widget.NumberPicker

fun NumberPicker.setDividerHeight(height: Int) {
    val pickerFields = NumberPicker::class.java.declaredFields
    for (pf in pickerFields) {
        if (pf.name == "mSelectionDividerHeight") {
            pf.isAccessible = true
            try {
                // set divider height in pixels
                pf.set(this, height)
            } catch (e: java.lang.IllegalArgumentException) {
                e.printStackTrace()
            } catch (e: Resources.NotFoundException) {
                e.printStackTrace()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            }
            break
        }
    }
}