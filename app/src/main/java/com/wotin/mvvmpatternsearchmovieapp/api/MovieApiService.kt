package com.wotin.mvvmpatternsearchmovieapp.api

import androidx.lifecycle.LiveData
import com.wotin.mvvmpatternsearchmovieapp.model.MovieCustomClass
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface MovieApiService {

    @Headers(*["X-Naver-Client-Id: nRNlTdQ0MwrEKpSAyvb3", "X-Naver-Client-Secret: v11KsaIiF0"])
    @GET("movie.json")
    suspend fun getMovies(
        @Query("query") title: String?
    ): MovieCustomClass

}