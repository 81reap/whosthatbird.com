package components

import Message
import external.AutoProcessor
import external.MultiModalityCausalLM
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import react.FC
import react.Props
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.label
import react.dom.events.KeyboardEvent
import react.useState
import csstype.*
import web.cssom.*
import emotion.react.css
import web.html.HTMLInputElement

// Define ChatProps that may be passed into the Chat component.
external interface ChatProps : Props {
		var messages: Array<Message>?
}

// Define ChatBubble for rendering an individual message.
external interface ChatBubbleProps : Props {
		var message: Message
}
val ChatBubble = FC<ChatBubbleProps> { props ->
		div {
				css {
						padding = Padding(0.5.rem, 0.5.rem)
						marginBottom = 0.5.rem
						borderRadius = 4.px
						// Color the bubble differently based on sender.
						backgroundColor = if (props.message.sender == "user")
								Color("#e5e5e5")
						else
								Color("#90EE90")
				}
				+props.message.text
		}
}

// Create a coroutine scope for asynchronous operations.
private val chatScope = MainScope()

// Updated Chat component that integrates Transformers.js (Janus Pro) into the chat.
val Chat = FC<ChatProps> { props ->
		// Use the provided messages or start with an empty list.
		val (messages, setMessages) = useState(props.messages?.toMutableList() ?: mutableListOf<Message>())
		// State for the current input text.
		val (inputText, setInputText) = useState("")
		// Flag to indicate if a response is being generated.
		val (loading, setLoading) = useState(false)

		// Helper to append a new message to the conversation.
		fun addMessage(message: Message) {
				setMessages((messages + message).toMutableList())
		}

		// Function to call the Janus Pro model and generate a response.
		fun generateResponse(userMessage: String) {
				setLoading(true)
				chatScope.launch {
						try {
								val modelId = "onnx-community/Janus-Pro-1B-ONNX"
								val processor = AutoProcessor.from_pretrained(modelId)
								// todo make optiomisations from here :: https://github.com/huggingface/transformers.js-examples/blob/main/janus-pro-webgpu/src/worker.js
								val model = MultiModalityCausalLM.from_pretrained(modelId)

								// Instead of using a string literal (which must be constant),
								// create an empty JS object and assign the 'text' property.
								val input = js("{}")
								input.text = userMessage

								// Call the generate method (adjust this call if your model returns data).
								model.generate(input)

								// Here we simulate the generated response.
								val generatedText = "This is a generated response for: '$userMessage'"

								addMessage(
										Message(
												id = messages.size + 1,
												sender = "system",
												text = generatedText
										)
								)
						} catch (e: dynamic) {
								addMessage(
										Message(
												id = messages.size + 1,
												sender = "system",
												text = "Error generating response: ${e.toString()}"
										)
								)
						} finally {
								setLoading(false)
						}
				}
		}

		// Render the conversation area.
		div {
				css {
						flex = Flex.content
						padding = 1.ch
				}
				messages.forEach { message ->
						ChatBubble {
								this.message = message
						}
				}
		}

		// Render the input area.
		div {
				css {
						marginTop = 2.ch
				}
				label {
						css {
								display = Display.block
								color = Color("#444")
								marginBottom = 1.ch
						}
						+"Mode :: Chat"
				}
				input {
						css {
								width = 100.pct
								padding = Padding(0.5.rem, 0.rem)
								border = Border(2.px, LineStyle.solid, Color("#d1d1d1"))
								backgroundColor = Color("#f5f5f5")
								fontFamily = FontFamily.monospace
						}
						placeholder = "Type Message..."
						value = inputText
						onChange = { event ->
								setInputText(event.target.value)
						}
						onKeyDown = { event: KeyboardEvent<HTMLInputElement> ->
								if (event.key == "Enter" && inputText.isNotBlank() && !loading) {
										val userMsg = Message(
												id = messages.size + 1,
												sender = "user",
												text = inputText
										)
										addMessage(userMsg)
										setInputText("")
										generateResponse(userMsg.text)
								}
						}
				}
				button {
						css {
								marginTop = 1.ch
								padding = Padding(0.5.rem, 1.rem)
								backgroundColor = NamedColor.springgreen
								border = Border(1.px, LineStyle.solid, Color("black"))
								cursor = web.cssom.Cursor.pointer
						}
						+"Send"
						onClick = {
								if (inputText.isNotBlank() && !loading) {
										val userMsg = Message(
												id = messages.size + 1,
												sender = "user",
												text = inputText
										)
										addMessage(userMsg)
										setInputText("")
										generateResponse(userMsg.text)
								}
						}
				}
				if (loading) {
						div {
								css {
										marginTop = 1.ch
										fontSize = 1.2.rem
										color = Color("gray")
								}
								+"Generating response..."
						}
				}
		}
}
