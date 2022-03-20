package com.example.todoapp.home

import androidx.lifecycle.ViewModel
import com.example.domain.model.Todo

class TodoListViewModel(): ViewModel() {

    private val tasksList = mutableListOf<Todo>()

    fun addTask(task: Todo) {
        tasksList.add(task)
    }

    fun getList(): MutableList<Todo> {
        return tasksList
    }

}