package vita.sokolova.kotlinmultiplatformsandbox.android.ui.views

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import vita.sokolova.kotlinmultiplatformsandbox.android.R
import vita.sokolova.kotlinmultiplatformsandbox.android.domain.models.Movie

const val MOVIES_LIST_TEST_TAG = "MOVIES_LIST_TEST_TAG"
const val NOTHING_TO_SHOW_TEST_TAG = "NOTHING_TO_SHOW_TEST_TAG"

@Composable
fun MoviesLazyColumn(lazyItems: List<Movie>) {
    LazyColumn(
        modifier = Modifier.testTag(MOVIES_LIST_TEST_TAG)
    ) {
        if (lazyItems.isEmpty()) {
            item { showEmptyResultsText(R.string.nothing_found_text) }
        } else {
            items(lazyItems) { item ->
                val modifier = Modifier
                    .padding(top = 4.dp, bottom = 4.dp)
                    .defaultMinSize(minHeight = 96.dp)
                    .fillMaxWidth()
                MovieCard(
                    modifier = modifier,
                    movie = item
                )
            }
        }
    }
}

@Composable
private fun showEmptyResultsText(@StringRes textRes: Int) {
    Text(
        modifier = Modifier
            .padding(top = 8.dp)
            .testTag(NOTHING_TO_SHOW_TEST_TAG)
            .fillMaxHeight(),
        color = MaterialTheme.colors.secondary,
        text = stringResource(id = textRes),
    )
}