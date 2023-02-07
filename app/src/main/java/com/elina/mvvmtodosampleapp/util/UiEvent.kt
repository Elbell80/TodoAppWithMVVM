package com.elina.mvvmtodosampleapp.util

sealed class UiEvent {
    object PopBackStack : UiEvent()
    data class Navigate(val route: String) : UiEvent()
    data class ShowSnackBar(
        var msg: String,
        var action: String? = null
    ) : UiEvent()
}