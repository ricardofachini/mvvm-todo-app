package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.ITaskRepositoryLocal
import com.example.domain.repository.ITaskRepositoryRemote
import kotlinx.coroutines.flow.Flow

class GetTasksUseCase(
    private val taskRepositoryLocal: ITaskRepositoryLocal,
    private val taskRepositoryRemote: ITaskRepositoryRemote,
) {

    suspend fun call(): List<Task> {
        //return taskLocalRepositoryLocal.getAllTasks()
        return taskRepositoryRemote.getTasks()
    }
}