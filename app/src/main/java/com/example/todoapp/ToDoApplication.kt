package com.example.todoapp

import android.app.Application


class ToDoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin
    }
}