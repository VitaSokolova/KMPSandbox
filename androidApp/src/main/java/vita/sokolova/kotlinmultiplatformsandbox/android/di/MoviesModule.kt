package vita.sokolova.kotlinmultiplatformsandbox.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import vita.sokolova.kotlinmultiplatformsandbox.data.MoviesRepositoryImpl
import vita.sokolova.kotlinmultiplatformsandbox.domain.repositories.MoviesRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MoviesModule {
    companion object {
        @Provides
        @Singleton
        fun bindMoviesRepository(): MoviesRepository = MoviesRepositoryImpl()
    }
}