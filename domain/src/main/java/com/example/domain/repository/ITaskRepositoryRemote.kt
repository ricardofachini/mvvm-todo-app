package com.example.domain.repository

import com.example.domain.model.Task

interface ITaskRepositoryRemote {

    suspend fun insertNewTask(task: Task)
}