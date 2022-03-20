package com.example.todoapp.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Todo
import com.example.todoapp.databinding.TodoItemBinding


class TasksViewHolder(private val todoBinding: TodoItemBinding):
    RecyclerView.ViewHolder(todoBinding.root) {
        fun bind(item: Todo) {
            with(todoBinding) {
                todoTitle.text = item.title
                checkbox.isChecked = item.isDone
                root.setOnClickListener {
                    checkbox.isChecked = !item.isDone
                }
            }
        }
}
