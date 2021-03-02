package com.example.androiddevchallenge.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.data.models.Movie
import com.example.androiddevchallenge.data.repository.MoviesLanesRepository
import com.example.androiddevchallenge.di.MovieDIGraph
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TrendingViewModel(
    private val moviesLanesRepository: MoviesLanesRepository = MovieDIGraph.moviesLanesRepository
) : ViewModel() {
    val trendingMoviesLiveData = MutableLiveData<List<Movie>>()
    val popularMoviesLiveData = MutableLiveData<List<Movie>>()
    val topRatedMovies = MutableLiveData<List<Movie>>()
    val topRatedTVShows = MutableLiveData<List<Movie>>()
    val trendingTVShowsLiveData = MutableLiveData<List<Movie>>()

    init {
        viewModelScope.launch {
            moviesLanesRepository.getTrendingMovies().collect {
                trendingMoviesLiveData.value = it
            }
            moviesLanesRepository.getPopularMovies().collect {
                popularMoviesLiveData.value = it
            }
            moviesLanesRepository.getTopRatedMovies().collect {
                topRatedMovies.value = it
            }
            // TODO create new model for TV showsq
//            moviesLanesRepository.getTopRatedTVShwos().collect {
//                topRatedTVShows.value = it
//            }
//            moviesLanesRepository.getTrendingTVShows().collect {
//                trendingTVShowsLiveData.value = it
//            }
        }
    }
}