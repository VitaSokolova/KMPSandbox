package vita.sokolova.kotlinmultiplatformsandbox.android.ui.entities

import vita.sokolova.kotlinmultiplatformsandbox.domain.entities.Movie

sealed interface MovieListScreenState {
    object EmptyQuery : MovieListScreenState
    data class Loading(val query: String) : MovieListScreenState
    data class Error(val query: String) : MovieListScreenState
    data class Data(val query: String, val movies: List<Movie>) : MovieListScreenState
}