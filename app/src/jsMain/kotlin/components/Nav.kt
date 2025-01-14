package components

import csstype.*
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
						padding = 0.5.rem
						textAlign = TextAlign.center
						position = Position.relative
				}
				ReactHTML.h1 {
						css {
								fontSize = 1.25.rem
								fontWeight = FontWeight.bold
						}
						+props.header
				}
		}

		ReactHTML.nav {
				css {
						backgroundColor = Color("#e5e5e5")
						padding = Padding(0.5.rem, 1.rem)
						display = Display.flex
						alignItems = AlignItems.center
						borderBottom = Border(2.px, LineStyle.solid, Color("black"))
				}

				ReactHTML.button {
						css {
								marginRight = 1.rem
						}
						+"✶"
				}

				ReactHTML.div {
						css {
								display = Display.flex
								gap = 1.rem
						}
						ReactHTML.button { +"FILE" }
						ReactHTML.button { +"EDIT" }
						ReactHTML.button { +"VIEW" }
				}

				ReactHTML.div {
						css {
								flexGrow = number(1.0)
						}
				}

				ReactHTML.button { +"HELP" }
		}
}