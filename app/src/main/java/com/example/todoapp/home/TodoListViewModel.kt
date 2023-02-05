package com.example.todoapp.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Task
import com.example.domain.usecase.AddTaskUseCase
import com.example.domain.usecase.DeleteTaskUseCase
import com.example.domain.usecase.GetTasksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase,
    private val getTasksUseCase: GetTasksUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
): ViewModel() {

    val tasksList = MutableLiveData<List<Task>>()

    /**
     * Adds a new task to the repositories
     */
    fun addTask(task: Task) {
        viewModelScope.launch {
            val result = addTaskUseCase.invoke(task)
            println("resultado addtask: $result")
            if (!result) {
                println("Erro ao inserir")
            }
        }
    }

    fun delete(id: Int) {
        viewModelScope.launch {
            val result = deleteTaskUseCase.delete(id)
        }
    }


    fun getAllTasks() {
        getTasksUseCase.call().onEach { data ->
            this.tasksList.value = data
        }.launchIn(viewModelScope)
    }

}