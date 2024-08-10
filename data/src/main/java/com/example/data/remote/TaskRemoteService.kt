package com.example.data.remote

import com.example.data.remote.entity.request.TaskRequest
import com.example.data.remote.entity.response.TaskResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface TaskRemoteService {

    @GET("tasks/list")
    suspend fun getAllTasks(): List<TaskResponse>

    @GET("tasks/{id}")
    suspend fun getTask(@Path("id") taskId: Int): TaskResponse

    @POST
    suspend fun addTask(@Body taskAnswer: TaskRequest)

}