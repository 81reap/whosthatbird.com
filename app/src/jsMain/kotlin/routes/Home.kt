package routes

import web.cssom.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.h2
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.button
import react.router.dom.Link

val Home = FC<Props> {
		div {
				css {
						padding = Padding(2.rem, 1.rem)
						margin = Margin(0.px, Auto.auto)
						textAlign = TextAlign.center
				}

				div {
						css {
								marginBottom = 2.rem
						}
						h1 {
								css {
										fontSize = 2.5.rem
										marginBottom = 0.5.rem
								}
								+"\uD83E\uDD9C Who's that bird?"
						}
						p {
								css {
										fontSize = 1.25.rem
										color = Color("#666")
										marginBottom = 1.rem
								}
								+"Your AI-powered bird identification companion"
						}

						// Call to Action
						div {
								css {
										display = Display.flex
										justifyContent = JustifyContent.center
										gap = 1.rem
										marginTop = 2.rem
								}

								Link {
										to = "scan"
										button {
												css {
														padding = Padding(0.75.rem, 1.5.rem)
														fontSize = 1.rem
														backgroundColor = NamedColor.springgreen
														border = Border(1.px, LineStyle.solid, Color("black"))
														cursor = Cursor.pointer
												}
												+"Start Scanning \uD83D\uDCF8"
										}
								}

								Link {
										to = "index"
										button {
												css {
														padding = Padding(0.75.rem, 1.5.rem)
														fontSize = 1.rem
														backgroundColor = NamedColor.blanchedalmond
														border = Border(1.px, LineStyle.solid, Color("black"))
														cursor = Cursor.pointer
												}
												+"View Bird Index \uD83D\uDCD3"
										}
								}
						}
				}

				div {
						css {
								display = Display.flex
								flexWrap = FlexWrap.wrap
								gap = 2.rem
								marginTop = 2.rem
								textAlign = TextAlign.left
								justifyContent = JustifyContent.center
						}

						FeatureCard {
								title = "Real-time Identification"
								description = "Point your camera at any bird and get instant identification using advanced AI technology"
								emoji = "\uD83D\uDD0E"
						}

						FeatureCard {
								title = "Comprehensive Database"
								description = "Collection of 48,000 pictures of the 400 birds in North America by The Cornell Lab of Ornithology"
								emoji = "\uD83D\uDCCA"
						}

						FeatureCard {
								title = "moondream 2"
								description = "Custom moondream 2 AI model for embedded inference."
								emoji = "\uD83E\uDD6E"
						}

						FeatureCard {
								title = "Enterprise Ready"
								description = "Written in Kotlin and backed by the JVM. Source code and Python training scripts available on GitHub!"
								emoji = "⚙\uFE0F "
						}
				}
		}
}

external interface FeatureCardProps : Props {
		var title: String
		var description: String
		var emoji: String
}

val FeatureCard = FC<FeatureCardProps> { props ->
		div {
				css {
						border = Border(1.px, LineStyle.solid, Color("black"))
						borderRadius = 6.px
						padding = 1.5.rem
						backgroundColor = Color("#f9f9f9")
						flexBasis = 80.ch
						flexGrow = number(1.0)
						flexShrink = number(1.0)
						minWidth = 250.px
						maxWidth = 350.px
				}
				div {
						css {
								fontSize = 1.5.rem
								marginBottom = 0.5.rem
						}
						+props.emoji
				}
				h2 {
						css {
								fontSize = 1.25.rem
								marginBottom = 0.5.rem
						}
						+props.title
				}
				p {
						css {
								color = Color("#666")
								fontSize = 1.rem
								lineHeight = 1.5.rem
						}
						+props.description
				}
		}
}
