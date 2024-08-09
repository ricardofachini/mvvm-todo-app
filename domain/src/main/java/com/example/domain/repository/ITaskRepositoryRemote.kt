package com.example.domain.repository

import com.example.domain.model.Task

interface ITaskRepositoryRemote {

    suspend fun getTasks(): List<Task>

    suspend fun insertNewTask(task: Task)
}