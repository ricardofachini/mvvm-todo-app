package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.ITaskRepositoryLocal

class AddTaskUseCase(
    private val taskLocalRepositoryLocal: ITaskRepositoryLocal
) {

    suspend fun invoke(): Boolean {
        return taskLocalRepositoryLocal.insertNewTask(Task(
            id = 0,
            title = "tarefa",
            isDone = false
        ))
    }
}