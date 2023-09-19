package vita.sokolova.kotlinmultiplatformsandbox.android.utils.di

import vita.sokolova.kotlinmultiplatformsandbox.android.utils.AndroidLoggerImpl
import vita.sokolova.kotlinmultiplatformsandbox.android.utils.Logger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoggerModule {

    @Binds
    @Singleton
    abstract fun provideLogger(logger: AndroidLoggerImpl): Logger
}