package com.example.playground.core.extensions

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Locale

fun String.toCustomDateFormat(): String {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("HH:mm – dd/MMM", Locale.getDefault())
        val date = inputFormat.parse(this)
        outputFormat.format(date)
    } catch (e: Exception) {
        e.printStackTrace()
        this
    }
}

fun Modifier.paddingValues(
): Modifier {
    return this.then(
        Modifier.padding(
            top = 10.dp,
            start = 4.dp,
            end = 4.dp,
            bottom = 0.dp
        )
    )
}