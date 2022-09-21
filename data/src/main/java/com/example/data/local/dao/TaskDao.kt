package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import com.example.data.local.entity.TaskLocal

@Dao
interface TaskDao {

    @Insert
    fun insert(tasks: TaskLocal)

    @Delete
    fun delete(task: TaskLocal)

}