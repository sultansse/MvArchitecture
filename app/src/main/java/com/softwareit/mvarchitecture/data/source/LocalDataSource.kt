package com.softwareit.mvarchitecture.data.source

import com.softwareit.mvarchitecture.R
import com.softwareit.mvarchitecture.domain.model.Todo

object LocalDataSource : DataSource {
    override fun getTodoList(): List<Todo> {
        return listOf(
            Todo(0, R.string.title_1, R.string.description_1),
            Todo(1, R.string.title_2, R.string.description_2),
            Todo(2, R.string.title_3, R.string.description_3),
            Todo(3, R.string.title_4, R.string.description_4),
            Todo(4, R.string.title_5, R.string.description_5),
            Todo(5, R.string.title_6, R.string.description_6)
        )
    }
}