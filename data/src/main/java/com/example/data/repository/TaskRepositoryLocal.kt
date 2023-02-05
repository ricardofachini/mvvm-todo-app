package com.example.data.repository

import com.example.data.local.AppDatabase
import com.example.data.local.entity.TaskLocal
import com.example.domain.model.Task
import com.example.domain.repository.ITaskRepositoryLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepositoryLocal @Inject constructor(
    private val database: AppDatabase
): ITaskRepositoryLocal {

    override fun getAllTasks(): Flow<List<Task>> {
        return database.taskDao().getAllTasks().map { data ->
            data.map { entity ->
                entity.toDomain()
            }
        }
    }

    override suspend fun insertNewTask(task: Task): Boolean {
        return try {
            database.taskDao().insert(task.toLocal())
            true
        } catch (throwable: Throwable) {
            println("erro: $throwable")
            return false
        }
    }

    override suspend fun deleteTask(taskId: Int): Boolean {
        return try {
            database.taskDao().delete(
                TaskLocal(
                    taskId,
                    "",
                    false
                )
            )
            true
        } catch (throwable: Throwable) {
            return false
        }
    }

    private fun TaskLocal.toDomain(): Task {
        return Task(
            id = id,
            title = title,
            isDone = isDone
        )
    }

    private fun Task.toLocal(): TaskLocal {
        return TaskLocal(
            id = id,
            title = title,
            isDone = isDone,
        )
    }
}