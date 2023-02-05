package com.example.todoapp.utils

import com.example.data.local.AppDatabase
import com.example.data.repository.TaskRepositoryLocal
import com.example.domain.repository.ITaskRepositoryLocal
import com.example.domain.usecase.AddTaskUseCase
import com.example.domain.usecase.DeleteTaskUseCase
import com.example.domain.usecase.GetTasksUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAddTaskUseCase(repositoryLocal: ITaskRepositoryLocal): AddTaskUseCase {
        return AddTaskUseCase(repositoryLocal)
    }

    @Singleton
    @Provides
    fun provideGetTasksUseCase(repositoryLocal: ITaskRepositoryLocal): GetTasksUseCase {
        return GetTasksUseCase(repositoryLocal)
    }

    @Singleton
    @Provides
    fun provideDeleteTaskUseCase(repositoryLocal: ITaskRepositoryLocal): DeleteTaskUseCase {
        return DeleteTaskUseCase(repositoryLocal)
    }

    @Provides
    @Singleton
    fun provideTaskLocalRepository(database: AppDatabase): ITaskRepositoryLocal {
        return TaskRepositoryLocal(database)
    }
}