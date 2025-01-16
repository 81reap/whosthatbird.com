package components

import Message
import web.cssom.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.label
import react.dom.html.ReactHTML.input

external interface ChatProps : Props {
		var messages: Array<Message>
}
val Chat = FC<ChatProps> { props ->
		div {
				css {
						flexGrow = number(1.0)
						padding = 1.ch
				}

				div {
						css {
								marginBottom = 1.ch
						}

						props.messages.forEach { message ->
								ChatBubble {
										this.message = message
								}
						}
				}

				Input()
		}
}

external interface ChatBubbleProps : Props {
		var message: Message
}
val ChatBubble = FC<ChatBubbleProps> { props ->
		div {
				css {
						display = Display.flex
						justifyContent = if (props.message.sender == "user")
								JustifyContent.flexEnd else JustifyContent.flexStart
						padding = if (props.message.sender == "user")
								Padding(0.ch, 0.ch, 0.ch, 1.ch) else Padding(0.ch, 1.ch, 0.ch, 0.ch)
						marginBottom = 1.ch
				}

				div {
						css {
								maxWidth = 80.ch
								padding = 0.5.rem
								borderRadius = 4.px
								whiteSpace = WhiteSpace.preWrap
								wordWrap = WordWrap.breakWord
								overflowWrap = OverflowWrap.breakWord
								backgroundColor = if (props.message.sender == "user")
										Color("#e5e5e5") else Color("#90EE90")
						}
						+props.message.text
				}
		}
}

val Input = FC<Props> {
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
				}
		}
}