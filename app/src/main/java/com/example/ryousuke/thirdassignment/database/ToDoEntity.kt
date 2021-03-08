package com.example.ryousuke.thirdassignment.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
data class ToDoEntity(

    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var title: String,
    var description: String
)