package com.example.todoapp.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Task
import com.example.todoapp.databinding.TodoItemBinding


class TasksViewHolder(private val todoBinding: TodoItemBinding):
    RecyclerView.ViewHolder(todoBinding.root) {
    val checkBox = todoBinding.checkbox
        fun bind(item: Task) {
            with(todoBinding) {
                todoTitle.text = item.title
                checkbox.isChecked = item.isDone
                root.setOnClickListener {
                    checkbox.isChecked = !item.isDone
                }
            }
        }
}
