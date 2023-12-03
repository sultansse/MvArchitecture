package com.softwareit.mvarchitecture.domain.use_case

import com.softwareit.mvarchitecture.domain.model.Todo
import com.softwareit.mvarchitecture.domain.repository.TodoRepository

class GetTodoListUseCase(
    private val repository: TodoRepository
) {
    operator fun invoke(): List<Todo> {
        return repository.getTodoList()
    }
}