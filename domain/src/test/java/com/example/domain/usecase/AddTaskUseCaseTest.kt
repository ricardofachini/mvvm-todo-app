package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.ITaskRepositoryLocal
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class AddTaskUseCaseTest {
    private lateinit var useCase: AddTaskUseCase

    @Before
    fun setupTest() {
        val mockITaskRepositoryLocal: ITaskRepositoryLocal = mock()
        runBlocking {
            whenever(mockITaskRepositoryLocal.insertNewTask(Task(
                id = 0,
                title = "tarefa",
                isDone = false
            ))).thenReturn(true)
        }
        useCase = AddTaskUseCase(mockITaskRepositoryLocal)
    }

    @Test
    fun `test add new task`() {
        runBlocking {
            val result = useCase.invoke(
                Task(
                    id = 0,
                    title = "tarefa",
                    isDone = false)
            )
            if (!result) {
                fail()
            } else {
                assert(true)
            }
        }
    }
}