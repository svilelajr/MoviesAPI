package com.example.movies.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.model.Movie
import com.example.movies.network.MovieRestApiTask
import com.example.movies.repository.MovieRepository
import kotlin.concurrent.thread

class MovieListViewModel: ViewModel() {

    companion object{
        const val TAG = "MovieRepository"
    }


    private val movieRestApiTask = MovieRestApiTask()
    private val movieRepository = MovieRepository(movieRestApiTask)


    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
        get() = _moviesList


    fun init(){

        getAllMovies()

    }

    private fun getAllMovies(){
        Thread{
            try {
                _moviesList.postValue(movieRepository.getAllMovies())
            }catch (exception: Exception){
                Log.d(TAG, exception.message.toString())
            }
        }.start()

    }
}