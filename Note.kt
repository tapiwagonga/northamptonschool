package com.example.northamptonschool

import java.io.Serializable

data class Note(
    val id: String,
    val title: String,
    val content: String,
    val category: String
): Serializable
