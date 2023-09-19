package vita.sokolova.kotlinmultiplatformsandbox.android.data.entities

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class MoviesResponseDto(
    @SerialName("Search")
    val results: List<MovieDto>
)