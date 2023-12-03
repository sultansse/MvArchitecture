package com.softwareit.mvarchitecture.presentation.mvp

import com.softwareit.mvarchitecture.domain.model.Todo

sealed interface TodoScreen {
    interface View {
        fun showMessage(todo: Todo)
        fun showTodoList(todoList: List<Todo>)
    }

    interface Presenter {
        fun getTodoList()
        fun onTodoClick(todo: Todo)
    }
}