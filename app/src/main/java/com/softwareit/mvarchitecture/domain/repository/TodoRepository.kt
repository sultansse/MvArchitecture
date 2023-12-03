package com.softwareit.mvarchitecture.domain.repository

import com.softwareit.mvarchitecture.domain.model.Todo

interface TodoRepository {
    fun getTodoList(): List<Todo>
}