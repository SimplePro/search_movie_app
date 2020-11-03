package com.wotin.mvvmpatternsearchmovieapp.api

import androidx.lifecycle.LiveData
import com.wotin.mvvmpatternsearchmovieapp.model.MovieCustomClass
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object MovieRepository {

    var job : CompletableJob? = null

    fun getMovies(title : String): LiveData<MovieCustomClass> {
        job = Job()
        return object : LiveData<MovieCustomClass>() {
            override fun onActive() {
                super.onActive()
                job?.let { theJob ->
                    CoroutineScope(IO + theJob).launch {
                        val items = MovieRetrofitBuilder.movieApiService.getMovies(title)
                        withContext(Main) {
                            value = items
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJobs() {
        job?.cancel()
    }
}