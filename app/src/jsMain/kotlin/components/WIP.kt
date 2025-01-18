package components

import GitHub
import emotion.react.css
import web.cssom.*
import react.FC
import react.Props
import react.dom.html.ReactHTML.a
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.img
import react.dom.html.ReactHTML.p

val WIP = FC<Props> {
		div {
				css {
						// Centering and layout
						display = Display.flex
						flexDirection = FlexDirection.column
						alignItems = AlignItems.center
						justifyContent = JustifyContent.center

						// Spacing & sizing
						padding = 2.rem
						margin = Auto.auto
						maxWidth = 50.vw

						// Themed border and background
						border = Border(2.px, LineStyle.solid, NamedColor.black)
						backgroundColor = Color("#f9f9f9")

						// Text styling
						textAlign = TextAlign.center
						fontFamily = FontFamily.monospace
				}

				// Title
				h1 {
						css {
								fontSize = 2.rem
								marginBottom = 1.rem
						}
						+"🚧 Under Construction 🚧"
				}

				// Subtitle
				p {
						css {
								fontSize = 1.2.rem
								color = Color("#666")
								marginBottom = 2.rem
						}
						+"We're working hard to bring you something amazing. Check back soon!"
				}

				// GitHub link
				a {
						css {
								// The link itself
								display = Display.inlineFlex
								alignItems = AlignItems.center
								gap = 0.5.rem

								textDecoration = None.none
								color = NamedColor.black
								border = Border(2.px, LineStyle.solid, NamedColor.black)
								padding = Padding(0.5.rem, 1.rem)
								backgroundColor = Color("#e5e5e5")
								cursor = Cursor.pointer

								hover {
										backgroundColor = Color("#d1d1d1")
								}
						}
						href = "https://github.com/81reap/whosthatbird.com"
						//target = "_blank"
						//rel = "noopener noreferrer"

						// Inline SVG
						GitHub {
								size = 1.75
						}

						+"View on GitHub"
				}
		}
}
