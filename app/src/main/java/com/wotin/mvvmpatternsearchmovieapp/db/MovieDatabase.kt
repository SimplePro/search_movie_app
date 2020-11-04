package com.wotin.mvvmpatternsearchmovieapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wotin.mvvmpatternsearchmovieapp.dao.MovieDao
import com.wotin.mvvmpatternsearchmovieapp.model.ItemCustomClass

@Database(entities = [ItemCustomClass::class], version = 1)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao() : MovieDao
}