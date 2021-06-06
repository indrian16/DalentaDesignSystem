package tech.dalenta.component.listener

interface WatchTextListener {
    fun onTextChanged(value: String, start: Int, before: Int, count: Int)
}
