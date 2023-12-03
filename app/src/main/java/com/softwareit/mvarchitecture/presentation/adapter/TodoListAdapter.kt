package com.softwareit.mvarchitecture.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.softwareit.mvarchitecture.domain.model.Todo
import com.softwareit.mvarchitecture.databinding.ItemTodoBinding

class TodoListAdapter(
    private val onTodoClick: (Todo) -> Unit = {}
) : ListAdapter<Todo, TodoListAdapter.TodoViewHolder>(TodoDiffUtils) {
    object TodoDiffUtils : DiffUtil.ItemCallback<Todo>() {
        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TodoViewHolder(
        private val binding: ItemTodoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(todo: Todo) {
            binding.title.text = itemView.context.getString(todo.title)
            binding.description.text = itemView.context.getString(todo.description)
            itemView.setOnClickListener {
                onTodoClick(todo)
            }
        }
    }
}