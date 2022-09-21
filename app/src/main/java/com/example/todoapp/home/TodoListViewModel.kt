package com.example.todoapp.home

import androidx.lifecycle.ViewModel
import com.example.domain.model.Task

class TodoListViewModel(): ViewModel() {

    private val tasksList = mutableListOf<Task>()

    fun addTask(task: Task) {
        tasksList.add(task)
    }

    fun getList(): MutableList<Task> {
        return tasksList
    }

}