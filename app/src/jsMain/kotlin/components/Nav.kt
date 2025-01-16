package components

import web.cssom.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML

external interface NavProps : Props {
		var header: String
}

val Nav = FC<NavProps> { props ->
		ReactHTML.header {
				css {
						borderBottom = Border(2.px, LineStyle.solid, Color("black"))
						padding = 1.ch
						textAlign = TextAlign.center
						position = Position.relative
				}
				ReactHTML.h1 {
						css {
								fontSize = 3.ch
								fontWeight = FontWeight.bold
						}
						+props.header
				}
		}

		ReactHTML.nav {
				css {
						backgroundColor = Color("#e5e5e5")
						padding = 1.ch
						display = Display.flex
						alignItems = AlignItems.center
						borderBottom = Border(2.px, LineStyle.solid, Color("black"))
				}

				ReactHTML.button {
						css {
								marginRight = 2.ch
						}
						+"\uD83E\uDEB4"
				}

				ReactHTML.div {
						css {
								display = Display.flex
								gap = 1.ch
						}
						ReactHTML.button { +"SCAN" }
						ReactHTML.button { +"DATABASE" }
				}

				ReactHTML.div {
						css {
								flexGrow = number(1.0)
						}
				}

				ReactHTML.button { +"GitHub" }
		}
}