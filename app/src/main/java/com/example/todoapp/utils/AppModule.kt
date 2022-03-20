package com.example.todoapp.utils

import com.example.todoapp.home.TodoListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModule {
    val appModule = module {
        viewModel {
            TodoListViewModel()
        }
    }
}