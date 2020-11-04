package com.wotin.mvvmpatternsearchmovieapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.wotin.mvvmpatternsearchmovieapp.model.ItemCustomClass

@Dao
interface MovieDao {

    @Query("SELECT * from movies")
    fun getTodoList() : LiveData<List<ItemCustomClass>>

    @Insert
    fun insertMovie(movie : ItemCustomClass)


    @Delete
    fun deleteTodo(movie : ItemCustomClass)
}