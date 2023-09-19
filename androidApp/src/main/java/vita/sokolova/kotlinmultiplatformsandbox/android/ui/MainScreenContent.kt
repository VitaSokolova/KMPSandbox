package vita.sokolova.kotlinmultiplatformsandbox.android.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vita.sokolova.kotlinmultiplatformsandbox.android.R
import vita.sokolova.kotlinmultiplatformsandbox.android.ui.entities.MovieListScreenState
import vita.sokolova.kotlinmultiplatformsandbox.android.ui.theme.SearchWithPaginationTaskTheme
import vita.sokolova.kotlinmultiplatformsandbox.android.ui.views.Loader
import vita.sokolova.kotlinmultiplatformsandbox.android.ui.views.MoviesLazyColumn
import vita.sokolova.kotlinmultiplatformsandbox.android.ui.views.NOTHING_TO_SHOW_TEST_TAG
import vita.sokolova.kotlinmultiplatformsandbox.android.ui.views.SearchField
import vita.sokolova.kotlinmultiplatformsandbox.domain.entities.Movie

@Composable
fun MainScreenContent(
    searchQuery: String,
    screenState: MovieListScreenState,
    onTextChanged: (String) -> Unit,
    onClearClick: () -> Unit
) {
    Column(
        Modifier
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
            .fillMaxSize()
    ) {
        SearchField(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .fillMaxWidth(),
            searchQuery = searchQuery,

            onTextChanged = { onTextChanged(it) },
            onClearClick = { onClearClick() })

        when (screenState) {
            is MovieListScreenState.Data -> MoviesLazyColumn(screenState.movies)
            MovieListScreenState.EmptyQuery -> {
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .testTag(NOTHING_TO_SHOW_TEST_TAG)
                        .fillMaxHeight(),
                    color = MaterialTheme.colors.secondary,
                    text = stringResource(id = R.string.start_typing_text),
                )
            }

            is MovieListScreenState.Error -> {
                Text(
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .testTag(NOTHING_TO_SHOW_TEST_TAG)
                        .fillMaxHeight(),
                    color = MaterialTheme.colors.error,
                    text = stringResource(id = R.string.error_text),
                )
            }

            is MovieListScreenState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Loader()
                }
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenLoadingContentPreview() {
    SearchWithPaginationTaskTheme() {
        MainScreenContent(
            searchQuery = "Léon: The Professional",
            MovieListScreenState.Loading("Léon: The Professional"),
            onTextChanged = {},
            onClearClick = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenErrorContentPreview() {
    SearchWithPaginationTaskTheme() {
        MainScreenContent(
            searchQuery = "Léon: The Professional",
            MovieListScreenState.Error("Léon: The Professional"),
            onTextChanged = {},
            onClearClick = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenEmptyQueryContentPreview() {
    SearchWithPaginationTaskTheme() {
        MainScreenContent(
            searchQuery = "Léon: The Professional",
            MovieListScreenState.EmptyQuery,
            onTextChanged = {},
            onClearClick = {}
        )
    }
}

@Composable
@Preview(showBackground = true)
fun MainScreenContentPreview() {
    SearchWithPaginationTaskTheme() {
        MainScreenContent(
            searchQuery = "Léon: The Professional",
            MovieListScreenState.Data("Léon: The Professional", listOf(createMovieStub())),
            onTextChanged = {},
            onClearClick = {}
        )
    }
}

private fun createMovieStub() = Movie(
    uniqueId = "1",
    title = "Léon: The Professional",
    poster = "https://test.nl",
    year = "2017"
)