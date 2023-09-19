package vita.sokolova.kotlinmultiplatformsandbox.android.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import vita.sokolova.kotlinmultiplatformsandbox.android.domain.repositories.MoviesRepository
import vita.sokolova.kotlinmultiplatformsandbox.android.ui.entities.MovieListScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val movies: Flow<MovieListScreenState> = _searchQuery
        .debounce(SEARCH_DEBOUNCE_ML)
        .flatMapLatest { query ->
            flow {
                if (query.isNotEmpty()) {
                    emit(MovieListScreenState.Loading(query))
                    emit(loadMovies(query))
                } else {
                    emit(MovieListScreenState.EmptyQuery)
                }
            }
        }

    private suspend fun loadMovies(query: String): MovieListScreenState {
        return viewModelScope.async(Dispatchers.IO) {
            try {
                MovieListScreenState.Data(query, moviesRepository.getSearchResults(query))
            } catch (e: Exception) {
                MovieListScreenState.Error(query)
            }
        }.await()
    }


    fun updateQuery(newQuery: String) {
        _searchQuery.value = newQuery
    }

    fun onClearButtonClick() {
        _searchQuery.value = ""
    }

    companion object {
        const val SEARCH_DEBOUNCE_ML = 250L
    }
}