package com.example.domain.usecase

import com.example.domain.repository.ITaskRepositoryLocal

class DeleteTaskUseCase(
    private val taskRepositoryLocal: ITaskRepositoryLocal
) {

    suspend fun delete(taskId: Int): Boolean {
        return taskRepositoryLocal.deleteTask(taskId)
    }
}