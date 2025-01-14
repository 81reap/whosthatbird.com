package components

import Message
import csstype.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.InputType
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.label
import react.dom.html.ReactHTML.input

external interface ChatProps : Props {
		var messages: Array<Message>
}

val Input = FC<Props> { props: Props ->
		div {
				css {
						marginTop = 2.rem
				}

				label {
						css {
								display = Display.block
								color = Color("#444")
								marginBottom = 0.5.rem
						}
						+"Message"
				}

				input {
						css {
								width = 100.pct
								padding = Padding(0.5.rem, 0.rem)
								border = Border(2.px, LineStyle.solid, Color("#d1d1d1"))
								backgroundColor = Color("#f5f5f5")
								fontFamily = FontFamily.monospace
						}
						placeholder = ""
						type = InputType.text
				}
		}
}

val Chat = FC<ChatProps> { props ->
		div {
				css {
						flexGrow = number(1.0)
						padding = 1.rem
				}

				div {
						css {
								marginBottom = 1.rem
						}

						props.messages.forEach { msg ->
								div {
										css {
												display = Display.flex
												justifyContent =
														if (msg.sender == "user") JustifyContent.flexEnd else JustifyContent.flexStart
												marginBottom = 0.5.rem
										}

										div {
												css {
														maxWidth = 40.ch
														padding = 0.5.rem
														borderRadius = 4.px
														whiteSpace = WhiteSpace.preWrap
														wordWrap = WordWrap.breakWord
														overflowWrap = OverflowWrap.breakWord
														backgroundColor = if (msg.sender == "user") Color("#e5e5e5") else Color("#90EE90")
												}
												+msg.text
										}
								}
						}
				}

				Input()
		}
}