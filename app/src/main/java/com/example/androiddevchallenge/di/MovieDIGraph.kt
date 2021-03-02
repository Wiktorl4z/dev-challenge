package com.example.androiddevchallenge.di

import com.example.androiddevchallenge.App
import com.example.androiddevchallenge.data.api.MovieApi
import com.example.androiddevchallenge.data.db.MoviesDatabase
import com.example.androiddevchallenge.data.repository.MovieRepositoryImpl
import com.example.androiddevchallenge.data.repository.MoviesLaneRepositoryImpl
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object MovieDIGraph {

    private val context = App.applicationContext()

    // create retrofit
    private val movieApi = MovieApi.invoke()

    //create room db
    private val movieDatabase = MoviesDatabase.getInstance(context)
    private val movieDao = movieDatabase.moviesDao()
    private val genreDao = movieDatabase.genreDao()

    //pass dependencies to repository
    val movieRepository by lazy {
        MovieRepositoryImpl(movieApi, movieDao, genreDao)
    }

    val moviesLanesRepository by lazy {
        MoviesLaneRepositoryImpl(movieApi)
    }

    val mainDispatcher: CoroutineDispatcher
        get() = Dispatchers.Main

    val ioDispatcher: CoroutineDispatcher
        get() = Dispatchers.IO

}