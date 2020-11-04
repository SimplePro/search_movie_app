package com.wotin.mvvmpatternsearchmovieapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.wotin.mvvmpatternsearchmovieapp.model.ItemCustomClass
import com.wotin.mvvmpatternsearchmovieapp.repositories.MoviesRepository

class LikeMoviesViewModel(application: Application) : AndroidViewModel(application) {
    private val mMovieRepository : MoviesRepository = MoviesRepository(application)
    private val mMovies : LiveData<List<ItemCustomClass>>

    init {
        mMovies = mMovieRepository.getMovieList()
    }

    fun getMovies() : LiveData<List<ItemCustomClass>> = mMovies

    fun insertMovies(movie : ItemCustomClass) {
        Thread(Runnable {
            mMovieRepository.insertMovie(movie)
        }).start()

    }

    fun deleteMovies(movie: ItemCustomClass) {
        Thread(Runnable {
            mMovieRepository.deleteMovie(movie)
        }).start()
    }

}