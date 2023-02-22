package com.example.domain.usecase

import com.example.domain.model.Task
import com.example.domain.repository.ITaskRepositoryLocal
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class DeleteTaskUseCaseTest {
    private lateinit var useCase: DeleteTaskUseCase

    @Before
    fun setupTest() {
        val repositoryMock: ITaskRepositoryLocal = mock()
        runBlocking {
            whenever(
                repositoryMock.deleteTask(
                    1
                )
            ).thenReturn(true)
        }
        useCase = DeleteTaskUseCase(repositoryMock)
    }

    @Test
    fun `test delete one task`() {
        runBlocking {
            val testResult = useCase.delete(1)
            assertEquals(true, testResult)
        }
    }
}