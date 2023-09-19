package vita.sokolova.kotlinmultiplatformsandbox.android.ui.views

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vita.sokolova.kotlinmultiplatformsandbox.android.ui.theme.SearchWithPaginationTaskTheme

const val LOADING_FOOTER_TEST_TAG = "LOADING_FOOTER_TEST_TAG"

@Composable
fun Loader() {
    CircularProgressIndicator(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
            .testTag(LOADING_FOOTER_TEST_TAG)
    )
}

@Preview(showBackground = true)
@Composable
fun LoadingItemPreview() {
    SearchWithPaginationTaskTheme {
        Loader()
    }
}