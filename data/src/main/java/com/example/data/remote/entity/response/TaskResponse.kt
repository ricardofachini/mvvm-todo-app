package com.example.data.remote.entity.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TaskResponse(

    @Json(name = "id")
    val taskId: Int,

    @Json(name = "title")
    val title: String,

    @Json(name = "description")
    val description: String,

    @Json(name = "is_completed")
    val isDone: Boolean,
)