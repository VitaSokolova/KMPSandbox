package vita.sokolova.kotlinmultiplatformsandbox.android.data

import vita.sokolova.kotlinmultiplatformsandbox.android.domain.models.Movie
import vita.sokolova.kotlinmultiplatformsandbox.android.domain.repositories.MoviesRepository
import vita.sokolova.kotlinmultiplatformsandbox.android.utils.Logger
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesCatalogApi: MoviesCatalogApi
) : MoviesRepository {

    override suspend fun getSearchResults(query: String): List<Movie> {
        return moviesCatalogApi.getMovies(query).results.map {
            Movie(it.id, it.title, it.poster, it.year)
        }
    }
}