package com.example.todo.models

import java.util.Date

data class TodoItem(
    val id:String,
    val text:String,
    val importance: Importance,
    val deadline :Date,
    val isCompleted : Boolean,
    val createdAt : Date,
    val updatedAt : Date,
)


enum class Importance {
    LOW, NORMAL, HIGH_IMPORTANCE
}