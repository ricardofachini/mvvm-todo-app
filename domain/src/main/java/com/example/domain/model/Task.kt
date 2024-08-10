package com.example.domain.model

data class Task(
    val id: Int,
    val title: String,
    var description: String,
    var isDone: Boolean,
)
