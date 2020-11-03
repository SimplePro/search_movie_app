package com.wotin.mvvmpatternsearchmovieapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MovieRetrofitBuilder {
    const val BASE_URL = "https://openapi.naver.com/v1/search/"

    val retrofitBuilder : Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }
    val movieApiService : MovieApiService by lazy {
        retrofitBuilder
            .build()
            .create(MovieApiService::class.java)
    }
}