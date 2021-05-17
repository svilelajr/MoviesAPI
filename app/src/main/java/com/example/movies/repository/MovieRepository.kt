package com.example.movies.repository

import android.util.Log
import com.example.movies.model.Movie
import com.example.movies.network.MovieRestApiTask

class MovieRepository(private val movieRestApiTask: MovieRestApiTask) {

    companion object{
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()


    fun getAllMovies(): List<Movie>{

        val request = movieRestApiTask.RetrofitApi().getAllMovies().execute()

        if (request.isSuccessful){
            request.body()?.let {
                movieList.addAll(it)
            }

        }else{
            request.errorBody()?.let {
                Log.d(TAG,it.toString())
            }
        }

        return movieList
    }

}