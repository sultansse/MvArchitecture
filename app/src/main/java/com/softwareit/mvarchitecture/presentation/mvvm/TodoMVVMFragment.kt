package com.softwareit.mvarchitecture.presentation.mvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.softwareit.mvarchitecture.databinding.FragmentTodoListBinding
import com.softwareit.mvarchitecture.presentation.adapter.TodoListAdapter

class TodoMVVMFragment : Fragment() {
    private val binding by lazy { FragmentTodoListBinding.inflate(layoutInflater) }
    private val viewModel: TodoViewModel by viewModels()
    private lateinit var adapter: TodoListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = TodoListAdapter {
            Toast.makeText(requireContext(), "MVVM: ${it.id}", Toast.LENGTH_SHORT).show()
        }
        binding.todoList.adapter = adapter
        viewModel.todoList.observe(viewLifecycleOwner, adapter::submitList)

        viewModel.getTodoList()
        return binding.root
    }
}