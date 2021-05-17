package com.example.movies.network

import com.example.movies.model.Movie
import retrofit2.Call
import retrofit2.http.GET

interface MovieAPI {

    @GET("/natanfelipe/FilmesFlixJson/master/moviesList")
    fun getAllMovies(): Call<List<Movie>>




}