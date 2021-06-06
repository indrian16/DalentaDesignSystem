package tech.dalenta.component.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun LocalDateTime.display(): String {
    val localDateTime = LocalDateTime.parse(this.toString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME)
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    return formatter.format(localDateTime)

}