package com.example.ryousuke.thirdassignment.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ToDoDao {

    // IGNORE means you don't want to change same data if it comes into your database
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertToDo(toDoEntity: ToDoEntity)

    /* You don't have to use suspend function because LiveData always observes data changes!!*/
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllData(): LiveData<List<ToDoEntity>>

}