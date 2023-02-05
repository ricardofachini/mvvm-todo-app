package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.ITaskRepositoryLocal

class AddTaskUseCase constructor(
    private val taskLocalRepositoryLocal: ITaskRepositoryLocal
) {

    suspend fun invoke(task: Task): Boolean {
        return taskLocalRepositoryLocal.insertNewTask(task)
    }
}