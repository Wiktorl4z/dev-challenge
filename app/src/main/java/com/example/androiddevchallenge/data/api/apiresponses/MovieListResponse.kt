package com.example.androiddevchallenge.data.api.apiresponses

import com.example.androiddevchallenge.data.models.Movie
import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    @SerializedName("pages") val pages: Int,
    @SerializedName("results") val movies: List<Movie>
)