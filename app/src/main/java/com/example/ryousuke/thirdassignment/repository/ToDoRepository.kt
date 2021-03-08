package com.example.ryousuke.thirdassignment.repository

import androidx.lifecycle.LiveData
import com.example.ryousuke.thirdassignment.database.ToDoDao
import com.example.ryousuke.thirdassignment.database.ToDoEntity
import javax.inject.Inject

class ToDoRepository @Inject constructor(
    val toDoDao: ToDoDao
) {

    suspend fun insertToDo(toDoEntity: ToDoEntity) = toDoDao.insertToDo(toDoEntity)

    fun getAllData(): LiveData<List<ToDoEntity>> = toDoDao.getAllData()
}