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
						borderBottom = Border(2.px, LineStyle.solid, Color("black"))
						padding = 1.ch
						textAlign = TextAlign.center
						position = Position.relative
				}
				ReactHTML.h1 {
						css {
								fontSize = 3.rem
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

				Link {
						to = "."
						ReactHTML.button {
								css {
										marginRight = 2.ch
										fontSize = 3.ch
								}
								+"\uD83E\uDEB4"
						}
				}

				ReactHTML.div {
						css {
								display = Display.flex
								gap = 1.ch
						}
						Link {
								to = "scan"
								ReactHTML.button {
										css {
												fontSize = 3.ch
										}
										+"SCAN"
								}
						}
						Link {
								to = "index"
								ReactHTML.button {
										css {
												fontSize = 3.ch
										}
										+"INDEX"
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
						ReactHTML.button {
								css {
										fontSize = 3.ch
								}
								+"GitHub"
						}
				}
		}
}