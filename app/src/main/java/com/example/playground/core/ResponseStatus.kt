package com.example.playground.core

sealed class ResponseStatus<out T> {
    data class Success<out T>(val data: T) : ResponseStatus<T>()
    data class Fail(val message: String) : ResponseStatus<Nothing>()
    object Loading : ResponseStatus<Nothing>()
}