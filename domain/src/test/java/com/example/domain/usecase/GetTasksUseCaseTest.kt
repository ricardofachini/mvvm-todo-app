package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.ITaskRepositoryLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.hamcrest.core.IsInstanceOf.instanceOf
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class GetTasksUseCaseTest {
    private lateinit var useCase: GetTasksUseCase

    @Before
    fun setupTest() {
        val repositoryMock: ITaskRepositoryLocal = mock()
        val task = Task(1, "task", false)
        val actual = mutableListOf<Task>()
        actual.add(task)
        whenever(repositoryMock.getAllTasks()).thenReturn( flow {
            emit(actual)
        })
        useCase = GetTasksUseCase(repositoryMock)
    }

    @Test
    fun `test get tasks`() {
        val result = useCase.call()
        assertThat(result, instanceOf(Flow::class.java))
    }
}