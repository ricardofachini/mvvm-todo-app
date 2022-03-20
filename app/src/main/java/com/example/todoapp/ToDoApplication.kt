package com.example.todoapp

import android.app.Application
import com.example.todoapp.utils.AppModule.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin


class ToDoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        //start Koin
        startKoin {
            androidContext(this@ToDoApplication)
            modules(appModule)
        }
    }
}