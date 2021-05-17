package com.example.movies.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRestApiTask {
    companion object{
        const val BASE_URL = "https://raw.githubusercontent.com/"
    }

    private fun movieProvider(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun RetrofitApi(): MovieAPI = movieProvider().create(MovieAPI::class.java)
}