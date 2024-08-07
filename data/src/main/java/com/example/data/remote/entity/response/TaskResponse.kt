package com.example.data.remote.entity.response

import com.squareup.moshi.Json

data class TaskResponse(
    @field:Json(name = "id") val taskId: Int,
    @field:Json(name = "title") val title: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "is_completed") val isDone: Boolean,
)