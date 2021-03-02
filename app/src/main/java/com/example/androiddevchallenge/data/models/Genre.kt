package com.example.androiddevchallenge.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "genres")
data class Genre(
    @PrimaryKey
    val id: Int,
    val name: String
)