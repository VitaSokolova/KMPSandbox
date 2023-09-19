package vita.sokolova.kotlinmultiplatformsandbox.android.utils

/**
 * Abstraction above platform logger
 */
interface Logger {

    fun error(e: Throwable)
}