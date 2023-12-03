package com.softwareit.mvarchitecture.data.repository

import com.softwareit.mvarchitecture.data.source.DataSource
import com.softwareit.mvarchitecture.domain.model.Todo
import com.softwareit.mvarchitecture.domain.repository.TodoRepository

class TodoRepositoryImpl(
    private val dataSource: DataSource
) : TodoRepository {
    override fun getTodoList(): List<Todo> = dataSource.getTodoList()
}