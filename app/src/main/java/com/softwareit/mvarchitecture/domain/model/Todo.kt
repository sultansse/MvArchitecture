package com.softwareit.mvarchitecture.domain.model

import androidx.annotation.StringRes

data class Todo(
    val id: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
)
