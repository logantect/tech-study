package io.logantect.algorithms

import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestWatcher
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback
import java.util.Optional

class MeasureTimeExtension : TestWatcher, BeforeTestExecutionCallback {

    companion object {
        private const val START_TIME_KEY = "start time"
    }

    override fun beforeTestExecution(context: ExtensionContext) {
        context.storeStartTime()
    }

    override fun testSuccessful(context: ExtensionContext) {
        logDuration(context, "succeeded")
    }

    override fun testFailed(context: ExtensionContext, cause: Throwable) {
        logDuration(context, "failed")
    }

    override fun testAborted(context: ExtensionContext, cause: Throwable) {
        logDuration(context, "was aborted")
    }

    override fun testDisabled(context: ExtensionContext, reason: Optional<String>) {
        println("Test ${context.displayName} was disabled")
    }

    private fun ExtensionContext.storeStartTime() {
        getStore(ExtensionContext.Namespace.GLOBAL).put(START_TIME_KEY, System.currentTimeMillis())
    }

    private fun ExtensionContext.getStartTime(): Long {
        return getStore(ExtensionContext.Namespace.GLOBAL).get(START_TIME_KEY) as Long
    }

    private fun logDuration(context: ExtensionContext, result: String) {
        val duration = System.currentTimeMillis() - context.getStartTime()
        println("Test ${context.displayName} $result and took $duration ms")
    }
}
