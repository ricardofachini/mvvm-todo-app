package com.example.data.remote

import com.example.data.remote.entity.response.TaskResponse
import retrofit2.http.GET
import retrofit2.http.Header

interface TaskRemoteService {

    @GET("tasks/")
    suspend fun getAllTasks(): List<TaskResponse>

}