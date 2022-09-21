package com.example.data.repository

import com.example.domain.model.Task
import com.example.domain.repository.ITaskRepositoryLocal


class TaskRepositoryLocal: ITaskRepositoryLocal {

    override suspend fun insertNewTask(task: Task): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTask(taskId: Int): Boolean {
        TODO()
    }
}