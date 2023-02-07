package com.elina.mvvmtodosampleapp.ui.add_edit_todo

sealed class AddEditEvent{
    data class OnTitleChange(val title : String) : AddEditEvent()
    data class OnDescriptionChange(val description : String) : AddEditEvent()
    object OnSaveTodoClick : AddEditEvent()
}
