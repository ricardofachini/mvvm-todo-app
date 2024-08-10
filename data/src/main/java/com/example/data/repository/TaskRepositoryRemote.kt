package com.example.data.repository

import com.example.data.remote.TaskRemoteService
import com.example.data.remote.entity.request.TaskRequest
import com.example.data.remote.entity.response.TaskResponse
import com.example.domain.model.Task
import com.example.domain.repository.ITaskRepositoryRemote
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryRemote @Inject constructor(
    private val service: TaskRemoteService
): ITaskRepositoryRemote {

    override suspend fun getTasks(): List<Task> {
        return service.getAllTasks().map {
            it.toDomain()
        }
    }

    override suspend fun insertNewTask(task: Task) {
        service.addTask(task.toData())
    }

    private fun Task.toData(): TaskRequest {
        return TaskRequest(
            title = title,
            description = "",
            isDone = isDone,
        )
    }

    private fun TaskResponse.toDomain(): Task {
        return Task(
            id = taskId,
            title = title,
            isDone = isDone
        )
    }
}