package com.wotin.mvvmpatternsearchmovieapp.repositories

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.wotin.mvvmpatternsearchmovieapp.dao.MovieDao
import com.wotin.mvvmpatternsearchmovieapp.db.MovieDatabase
import com.wotin.mvvmpatternsearchmovieapp.model.ItemCustomClass

class MoviesRepository(application: Application) {
    private var mMovieDatabase : MovieDatabase = Room.databaseBuilder(
        application.applicationContext,
        MovieDatabase::class.java, "movie.db"
    )
        .build()
    private var mMovieDao: MovieDao
    private var mMovieItems : LiveData<List<ItemCustomClass>>

    init {
        mMovieDao = mMovieDatabase.movieDao()
        mMovieItems = mMovieDao.getTodoList()
    }

    fun getMovieList() : LiveData<List<ItemCustomClass>> = mMovieItems

    fun insertMovie(movie : ItemCustomClass) {
        mMovieDao.insertMovie(movie)
    }

    fun deleteMovie(movie : ItemCustomClass) {
        mMovieDao.deleteTodo(movie)
    }

}