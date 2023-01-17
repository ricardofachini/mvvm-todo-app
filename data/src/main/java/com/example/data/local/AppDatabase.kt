package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.data.local.dao.TaskDao
import com.example.data.local.entity.TaskLocal


@Database(entities = [TaskLocal::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "TodoAppDatabase.db")
                .addCallback(
                    object : Callback() {
                    }
                )
                .build()
        }

    }
}