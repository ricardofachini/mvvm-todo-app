package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.ITaskRepositoryLocal
import kotlinx.coroutines.flow.Flow

class GetTasksUseCase(
    private val taskLocalRepositoryLocal: ITaskRepositoryLocal
) {

    fun call(): Flow<List<Task>> {
        return taskLocalRepositoryLocal.getAllTasks()
    }
}