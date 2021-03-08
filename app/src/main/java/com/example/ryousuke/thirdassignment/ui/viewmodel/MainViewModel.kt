package com.example.ryousuke.thirdassignment.ui.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ryousuke.thirdassignment.database.ToDoEntity
import com.example.ryousuke.thirdassignment.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// We can not use @ViewModelInject any more so, you should replace it as soon as possible!!
@HiltViewModel
class MainViewModel @Inject constructor(
   private val toDoRepository: ToDoRepository
) : ViewModel(){


    fun checkDataFromUser(title: String, description: String): Boolean {
        return !(title.isEmpty() || description.isEmpty())
    }

    fun insertToDo(toDoEntity: ToDoEntity){
        viewModelScope.launch(Dispatchers.IO) {
            toDoRepository.insertToDo(toDoEntity)
        }
    }

    fun getAllData(): LiveData<List<ToDoEntity>> = toDoRepository.getAllData()
}