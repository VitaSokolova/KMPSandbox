package vita.sokolova.kotlinmultiplatformsandbox.android.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import vita.sokolova.kotlinmultiplatformsandbox.android.data.MoviesCatalogApi
import vita.sokolova.kotlinmultiplatformsandbox.android.data.MoviesRepositoryImpl
import vita.sokolova.kotlinmultiplatformsandbox.android.domain.repositories.MoviesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MoviesModule {

    companion object {
        @Provides
        @Singleton
        fun provideMoviesCatalogApi(retrofit: Retrofit): MoviesCatalogApi {
            return retrofit.create(MoviesCatalogApi::class.java)
        }
    }

    @Binds
    @Singleton
    abstract fun bindMoviesRepository(moviesRepository: MoviesRepositoryImpl): MoviesRepository
}