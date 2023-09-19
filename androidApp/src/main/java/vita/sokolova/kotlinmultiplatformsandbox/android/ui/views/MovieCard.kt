package vita.sokolova.kotlinmultiplatformsandbox.android.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.skydoves.landscapist.glide.GlideImage
import vita.sokolova.kotlinmultiplatformsandbox.android.R
import vita.sokolova.kotlinmultiplatformsandbox.domain.entities.Movie
import vita.sokolova.kotlinmultiplatformsandbox.android.ui.theme.SearchWithPaginationTaskTheme

const val MOVIE_CARD_TEST_TAG = "MOVIE_CARD_TEST_TAG"

@Composable
fun MovieCard(modifier: Modifier, movie: Movie) {
    Card(
        modifier = modifier.testTag(MOVIE_CARD_TEST_TAG),
        shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val pictureModifier = Modifier
                .width(108.dp)
                .height(164.dp)
                .padding(end = 8.dp)
                .align(Alignment.CenterVertically)
            GlideImage(
                modifier = pictureModifier,
                imageModel = movie.poster,
                contentScale = ContentScale.Crop,
                loading = { ImagePlaceholder(modifier = pictureModifier) },
                failure = { ImagePlaceholder(modifier = pictureModifier) },
                previewPlaceholder = R.drawable.ic_launcher_background
            )
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = movie.title,
                    style = MaterialTheme.typography.h6
                )
//                Text(
//                    modifier = Modifier
//                        .padding(top = 8.dp)
//                        .fillMaxWidth(),
//                    text = movie.year,
//                    maxLines = 3,
//                    overflow = TextOverflow.Ellipsis,
//                    style = MaterialTheme.typography.subtitle1
//                )
                FlowRow(
                    modifier = Modifier.padding(top = 8.dp),
                    content = {
                         Chip(movie.year)
                    }
                )
            }
        }

    }
}

@Composable
fun ImagePlaceholder(modifier: Modifier) {
    Box(
        modifier = modifier
            .size(64.dp)
            .background(MaterialTheme.colors.background, shape = RoundedCornerShape(8.dp)),
    )
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    SearchWithPaginationTaskTheme {
        MovieCard(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
                .defaultMinSize(minHeight = 90.dp)
                .fillMaxWidth(),
            movie = Movie(
                uniqueId = "1",
                title = "Léon: The Professional",
                poster = "https://test.nl",
                year = "2017"
            )
        )
    }
}