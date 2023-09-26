package vita.sokolova.kotlinmultiplatformsandbox.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import vita.sokolova.kotlinmultiplatformsandbox.di.SharedModule

open class BaseApp : Application()

@HiltAndroidApp
class App : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        SharedModule.init(this)
    }
}