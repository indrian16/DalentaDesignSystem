package tech.dalenta.component.utils

interface WatchTextListener {
    fun onTextChanged(value: String, start: Int, before: Int, count: Int)
}
