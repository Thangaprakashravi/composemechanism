package com.example.cachemechanism

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class Post(
    @PrimaryKey val id: Int,
    val title: String,
    val body: String
)

