package com.softwareit.mvarchitecture.presentation.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softwareit.mvarchitecture.data.repository.TodoRepositoryImpl
import com.softwareit.mvarchitecture.data.source.LocalDataSource
import com.softwareit.mvarchitecture.domain.model.Todo
import com.softwareit.mvarchitecture.domain.use_case.GetTodoListUseCase
import kotlinx.coroutines.launch

class TodoViewModel(
    private val getTodoListUseCase: GetTodoListUseCase = GetTodoListUseCase(TodoRepositoryImpl(
        LocalDataSource
    ))
) : ViewModel() {

    private val _todoList = MutableLiveData<List<Todo>?>()
    val todoList: LiveData<List<Todo>?> = _todoList

    fun getTodoList() = viewModelScope.launch {
        _todoList.postValue(getTodoListUseCase())
    }
}