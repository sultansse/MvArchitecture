package com.softwareit.mvarchitecture.data.source

import com.softwareit.mvarchitecture.domain.model.Todo

interface DataSource {
    fun getTodoList(): List<Todo>
}