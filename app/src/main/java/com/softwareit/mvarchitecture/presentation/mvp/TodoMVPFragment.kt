package com.softwareit.mvarchitecture.presentation.mvp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.softwareit.mvarchitecture.databinding.FragmentTodoListBinding
import com.softwareit.mvarchitecture.domain.model.Todo
import com.softwareit.mvarchitecture.presentation.adapter.TodoListAdapter

class TodoMVPFragment : Fragment(), TodoScreen.View {
    private val binding by lazy { FragmentTodoListBinding.inflate(layoutInflater) }
    private lateinit var presenter: TodoScreen.Presenter
    private lateinit var adapter: TodoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        presenter = TodoPresenter(this)
        adapter = TodoListAdapter(presenter::onTodoClick)
        binding.todoList.adapter = adapter

        presenter.getTodoList()
        return binding.root
    }

    override fun showMessage(todo: Todo) {
        Toast.makeText(requireContext(), "MVP: ${todo.id}", Toast.LENGTH_SHORT).show()
    }

    override fun showTodoList(todoList: List<Todo>) {
        adapter.submitList(todoList)
    }
}