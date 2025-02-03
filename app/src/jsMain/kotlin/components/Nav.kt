package components

import web.cssom.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML
import react.router.dom.Link

external interface NavProps : Props {
		var header: String
}
val Nav = FC<NavProps> { props ->

		ReactHTML.header {
				css {
						borderBottom = Border(2.px, LineStyle.solid, NamedColor.black)
						padding = 0.75.rem
						textAlign = TextAlign.center
						position = Position.relative
						backgroundColor = NamedColor.cornflowerblue
				}
				ReactHTML.h1 {
						css {
								fontSize = 2.rem
								fontWeight = FontWeight.bold
								margin = 0.px
						}
						+props.header
				}
		}

		ReactHTML.nav {
				css {
						backgroundColor = NamedColor.darksalmon
						padding = 0.5.rem
						display = Display.flex
						alignItems = AlignItems.center
						borderBottom = Border(1.px, LineStyle.solid, NamedColor.black)
						gap = 1.rem
				}

				Link {
						to = "."
						NavButton{
								text = "\uD83E\uDEB4"
						}
				}

				ReactHTML.div {
						css {
								display = Display.flex
								gap = 1.ch
						}
						Link {
								to = "Chat"
								NavButton{
										text = "CHAT"
								}
						}
						Link {
								to = "index"
								NavButton{
										text = "INDEX"
								}
						}
				}

				ReactHTML.div {
						css {
								flexGrow = number(1.0)
						}
				}

				Link {
						to = "https://github.com/81reap/whosthatbird.com"
						NavButton{
								text = "GitHub"
						}
				}
		}
}

external interface NavButtonProps : Props {
		var text: String
}
val NavButton = FC<NavButtonProps> { props ->
		ReactHTML.button {
				css {
						fontSize = 1.25.rem
						height = 100.pct
						cursor = Cursor.pointer
						border = Border(1.px, LineStyle.solid, NamedColor.black)
						backgroundColor = NamedColor.antiquewhite
				}
				+props.text
		}
}