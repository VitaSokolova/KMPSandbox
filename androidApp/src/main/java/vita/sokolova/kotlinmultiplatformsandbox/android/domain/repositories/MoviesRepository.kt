package vita.sokolova.kotlinmultiplatformsandbox.android.domain.repositories

import vita.sokolova.kotlinmultiplatformsandbox.android.domain.models.Movie

interface MoviesRepository {
    suspend fun getSearchResults(query: String): List<Movie>
}