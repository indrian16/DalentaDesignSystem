package tech.dalenta.component.listener

import java.time.LocalDateTime

interface DatePickerListener {

    fun onUpdateDate(currentDate: LocalDateTime)
}