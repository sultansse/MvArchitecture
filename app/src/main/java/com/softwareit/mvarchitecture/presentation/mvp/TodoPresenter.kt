package com.softwareit.mvarchitecture.presentation.mvp

import com.softwareit.mvarchitecture.data.repository.TodoRepositoryImpl
import com.softwareit.mvarchitecture.data.source.LocalDataSource
import com.softwareit.mvarchitecture.domain.model.Todo
import com.softwareit.mvarchitecture.domain.use_case.GetTodoListUseCase

class TodoPresenter(
    private val view: TodoScreen.View
) : TodoScreen.Presenter {

    private val getTodoListUseCase: GetTodoListUseCase = GetTodoListUseCase(TodoRepositoryImpl(
        LocalDataSource
    ))

    override fun getTodoList() {
        view.showTodoList(getTodoListUseCase())
    }

    override fun onTodoClick(todo: Todo) {
        view.showMessage(todo)
    }
}