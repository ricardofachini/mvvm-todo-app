package com.example.data.local

import android.content.Context
import androidx.room.Room
import com.example.data.local.AppDatabase
import com.example.data.local.dao.TaskDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
//        return Room.databaseBuilder(context, AppDatabase::class.java, "TodoAppDatabase.db")
//            .build()
    }

    @Provides
    fun provideTaskDao(appDatabase: AppDatabase): TaskDao {
        return appDatabase.taskDao()
    }
}