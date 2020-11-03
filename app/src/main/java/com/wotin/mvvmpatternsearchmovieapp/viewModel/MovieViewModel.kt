package com.wotin.mvvmpatternsearchmovieapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.wotin.mvvmpatternsearchmovieapp.api.MovieRepository
import com.wotin.mvvmpatternsearchmovieapp.model.MovieCustomClass

class MovieViewModel : ViewModel() {
    val _title : MutableLiveData<String> = MutableLiveData()

    val movie : LiveData<MovieCustomClass> = Transformations
        .switchMap(_title) {title ->
            MovieRepository.getMovies(title)
        }

    fun setSearchTitle(title : String) {
        if(_title.value == title) return
        _title.value = title
    }

    fun cancelJobs() {
        MovieRepository.cancelJobs()
    }
}