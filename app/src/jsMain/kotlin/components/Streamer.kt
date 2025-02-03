package components

import external.BaseStreamer
import kotlinx.serialization.Serializable

@Serializable
data class Data(val progress: Double, val time: Double)

class ProgressStreamer(
		private val total: Int,
		private val onProgress: (progressInfo: dynamic) -> Unit
) : BaseStreamer() {
		private var count: Int = 0
		private val startTime: Double = js("performance.now()") as Double

		override fun put() {
				count++
				val progress = count.toDouble() / total.toDouble()
				val elapsed = (js("performance.now()") as Double) - startTime
				onProgress(Data(progress, elapsed))
		}

		override fun end() {
				// No additional operation.
		}
}
