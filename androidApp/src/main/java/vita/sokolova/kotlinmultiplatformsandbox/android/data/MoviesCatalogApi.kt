package vita.sokolova.kotlinmultiplatformsandbox.android.data

import vita.sokolova.kotlinmultiplatformsandbox.android.data.entities.MoviesResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesCatalogApi {

    @GET("https://www.omdbapi.com/")
    suspend fun getMovies(
        @Query("s") query: String
    ): MoviesResponseDto
}