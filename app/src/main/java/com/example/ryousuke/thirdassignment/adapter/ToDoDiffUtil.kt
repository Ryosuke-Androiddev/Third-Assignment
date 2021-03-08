package com.example.ryousuke.thirdassignment.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.ryousuke.thirdassignment.database.ToDoEntity

class ToDoDiffUtil(
    private val oldList: List<ToDoEntity>,
    private val newList: List<ToDoEntity>
): DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
                && oldList[oldItemPosition].title == newList[newItemPosition].title
                && oldList[oldItemPosition].description == newList[newItemPosition].description
    }

}