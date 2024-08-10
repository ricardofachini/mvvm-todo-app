package com.example.domain.repository

import com.example.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface ITaskRepositoryLocal {

    suspend fun getAllTasks(): Flow<List<Task>>

    suspend fun insertNewTask(task: Task): Boolean

    suspend fun deleteTask(taskId: Int): Boolean
}