package com.example.android.core.utils

sealed class ViewState<out T : Any> {
    fun <R : Any> isSuccess(action: (T) -> R): ViewState<R> {
        return when (this) {
            Loading -> Loading
            is Success -> Success(action(result))
            is Error -> Error(exception)
        }
    }

    object Loading : ViewState<Nothing>()
    data class Success<out T : Any>(val result: T) : ViewState<T>()
    data class Error(val exception: Throwable) : ViewState<Nothing>()
}