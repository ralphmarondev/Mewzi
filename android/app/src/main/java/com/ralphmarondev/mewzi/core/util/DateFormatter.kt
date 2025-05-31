package com.ralphmarondev.mewzi.core.util

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

// MM-dd-yy h:mma
// 05-31-25 9:25AM
fun formatDateTime(isoString: String): String {
    return try {
        val zonedDateTime = ZonedDateTime.parse(isoString)
        val formatter = DateTimeFormatter.ofPattern("MM-dd-yy h:mma", Locale.ENGLISH)
        zonedDateTime.format(formatter)
    } catch (e: Exception) {
        "Invalid date"
    }
}