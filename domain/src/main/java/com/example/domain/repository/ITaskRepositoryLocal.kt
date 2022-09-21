package com.example.domain.repository

import com.example.domain.model.Task

interface ITaskRepositoryLocal {

    suspend fun insertNewTask(task: Task): Boolean {
        TODO()
    }

    suspend fun deleteTask(taskId: Int): Boolean {
        TODO()
    }
}