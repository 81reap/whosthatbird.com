@file:JsModule("@huggingface/transformers")
@file:JsNonModule

package external

// External declarations for the transformer classes used in your app.
external class AutoProcessor {
		companion object {
				suspend fun from_pretrained(modelId: String, options: dynamic = definedExternally): AutoProcessor
		}
		operator fun invoke(conversation: dynamic, options: dynamic = definedExternally): dynamic
		val tokenizer: dynamic
		val num_image_tokens: Int
}

external class MultiModalityCausalLM {
		companion object {
				suspend fun from_pretrained(modelId: String, options: dynamic = definedExternally): MultiModalityCausalLM
		}
		suspend fun generate_images(options: dynamic): Array<dynamic>
		suspend fun generate(options: dynamic)
}

external open class InterruptableStoppingCriteria {
		fun reset()
		fun interrupt()
}

external class TextStreamer(tokenizer: dynamic, options: dynamic) : BaseStreamer

// BaseStreamer is meant to be subclassed in Kotlin.
external open class BaseStreamer {
		open fun put()
		open fun end()
}
