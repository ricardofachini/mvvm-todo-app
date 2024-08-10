package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.ITaskRepositoryLocal
import com.example.domain.repository.ITaskRepositoryRemote

class AddTaskUseCase constructor(
    private val taskRepositoryLocal: ITaskRepositoryLocal,
    private val taskRepositoryRemote: ITaskRepositoryRemote,
) {

    suspend fun invoke(task: Task): Boolean {
        return taskRepositoryLocal.insertNewTask(task)
    }
}