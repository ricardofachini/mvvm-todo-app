package com.example.todoapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class ToDoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        //start Koin
        startKoin {
            androidLogger()
            androidContext(this@ToDoApplication)
            modules()
        }
    }
}