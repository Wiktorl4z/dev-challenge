package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RemoveCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.SpotifyDataProvider
import com.example.androiddevchallenge.data.models.Movie
import com.example.androiddevchallenge.horizontalGradientBackground
import com.example.androiddevchallenge.ui.theme.typography
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun WatchlistScreen(moviesHomeInteractionEvents: (MoviesHomeInteractionEvents) -> Unit) {
    val surfaceGradient = SpotifyDataProvider.spotifySurfaceGradient(isSystemInDarkTheme())
    val viewModel: MoviesHomeViewModel = viewModel()
    val myWatchlist by viewModel.myWatchlist.observeAsState(emptyList())
    if (myWatchlist.isNotEmpty()) {
        Surface(modifier = Modifier.horizontalGradientBackground(surfaceGradient)) {
        }
    } else {
        EmptyWatchlistSection()
    }
}

@Composable
fun MovieWatchlistItem(
    movie: Movie,
    onMovieSelected: () -> Unit,
    onRemoveFromWatchlist: () -> Unit
) {
    Box(modifier = Modifier.clickable(onClick = onMovieSelected)) {
        CoilImage(
            data = "https://image.tmdb.org/t/p/original/${movie.backdrop_path}",
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Text(
            text = movie.title,
            style = typography.h6.copy(fontWeight = FontWeight.ExtraBold),
            modifier = Modifier.align(Alignment.BottomStart).padding(8.dp)
        )
        IconButton(
            onClick = { onRemoveFromWatchlist.invoke() },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(imageVector = Icons.Default.RemoveCircleOutline, contentDescription = null)
        }
    }
}

@Composable
fun EmptyWatchlistSection() {
    Column {
        Spacer(modifier = Modifier.padding(100.dp))
        Text(
            text = "Watchlist is empty",
            style = typography.h6,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Text(
            text = "Please add some movies to your watchlist",
            style = typography.caption,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}