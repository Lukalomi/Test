package com.example.playground.core.extensions

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