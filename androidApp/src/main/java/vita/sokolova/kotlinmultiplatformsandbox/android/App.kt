package vita.sokolova.kotlinmultiplatformsandbox.android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

open class BaseApp : Application()

@HiltAndroidApp
class App : BaseApp()