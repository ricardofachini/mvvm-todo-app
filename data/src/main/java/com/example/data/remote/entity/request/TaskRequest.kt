package com.example.data.remote.entity.request

import com.squareup.moshi.Json

data class TaskRequest (
    @field:Json(name = "title") val title: String,
    @field:Json(name = "description") val description: String,
    @field:Json(name = "is_completed") val isDone: Boolean,
)