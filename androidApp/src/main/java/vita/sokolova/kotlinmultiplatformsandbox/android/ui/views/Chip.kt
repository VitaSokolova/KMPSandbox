package vita.sokolova.kotlinmultiplatformsandbox.android.ui.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vita.sokolova.kotlinmultiplatformsandbox.android.ui.theme.SearchWithPaginationTaskTheme

@Composable
fun Chip(
    text: String
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colors.primary
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text(modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp), text = text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ChopPreview() {
    SearchWithPaginationTaskTheme {
        Chip(text = "Chip")
    }
}