package com.example.androiddevchallenge

import android.graphics.Bitmap
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette
import com.example.androiddevchallenge.ui.theme.graySurface

object SpotifyDataProvider {
    fun spotifySurfaceGradient(isDark: Boolean) =
        if (isDark) listOf(graySurface, Color.Black) else listOf(Color.White, Color.LightGray)

    val listOfSpotifyHomeLanes = listOf(
        "Continue listening",
        "Popular Playlists",
        "Top Charts",
        "Recommended for today",
        "Bollywood",
        "Acoustic only"
    )

    fun generateDominantColorState(bitmap: Bitmap): Palette.Swatch {
        return Palette.Builder(bitmap)
            .resizeBitmapArea(0)
            .maximumColorCount(16)
            .generate()
            .swatches
            .maxByOrNull { swatch -> swatch.population }!!

    }

}