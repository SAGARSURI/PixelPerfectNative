package com.example.android.core.utils

sealed class ViewState<out T : Any> {
    object Loading : ViewState<Nothing>()
    data class Success<out T : Any>(val result: T) : ViewState<T>()
    data class Error(val exception: Throwable) : ViewState<Nothing>()
}