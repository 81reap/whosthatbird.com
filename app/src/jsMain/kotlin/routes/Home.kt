package routes

import web.cssom.*
import emotion.react.css
import react.FC
import react.Props
import react.create
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.h2
import react.dom.html.ReactHTML.p
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.img
import react.router.dom.Link

val Home = FC<Props> {
		div {
				css {
						padding = Padding(4.rem, 2.rem)
						margin = Margin(0.px, Auto.auto)
						textAlign = TextAlign.center
				}

				// Hero Section
				div {
						css {
								marginBottom = 4.rem
						}
						h1 {
								css {
										fontSize = 4.rem
										marginBottom = 1.rem
								}
								+"🦜 Who's that bird?"
						}
						p {
								css {
										fontSize = 1.5.rem
										color = Color("#666")
										marginBottom = 2.rem
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
														padding = Padding(1.rem, 2.rem)
														fontSize = 1.25.rem
														backgroundColor = Color("#90EE90")
														border = Border(2.px, LineStyle.solid, Color("black"))
														cursor = Cursor.pointer
														hover {
																backgroundColor = Color("#7BC67B")
														}
												}
												+"Start Scanning 📸"
										}
								}
								Link {
										to = "index"
										button {
												css {
														padding = Padding(1.rem, 2.rem)
														fontSize = 1.25.rem
														backgroundColor = Color("#e5e5e5")
														border = Border(2.px, LineStyle.solid, Color("black"))
														cursor = Cursor.pointer
														hover {
																backgroundColor = Color("#d1d1d1")
														}
												}
												+"View Bird Index 📚"
										}
								}
						}
				}

				div {
						css {
								display = Display.flex
								flexWrap = FlexWrap.wrap
								gap = 2.rem
								marginTop = 4.rem
								textAlign = TextAlign.left
								justifyContent = JustifyContent.center
						}

						FeatureCard {
								title = "Real-time Identification"
								description = "Point your camera at any bird and get instant identification using advanced AI technology"
								emoji = "🔍"
						}

						FeatureCard {
								title = "Comprehensive Database"
								description = "Collection of 48,000 pictures of the 400 birds in North America by The Cornell Lab of Ornithology"
								emoji = "📊"
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
						border = Border(2.px, LineStyle.solid, Color("black"))
						borderRadius = 8.px
						padding = 2.rem
						backgroundColor = Color("#f9f9f9")
						flexBasis = 80.ch
						flexGrow = number(1.0)
						flexShrink = number(1.0)
						minWidth = 250.px
						maxWidth = 350.px
				}
				div {
						css {
								fontSize = 2.rem
								marginBottom = 1.rem
						}
						+props.emoji
				}
				h2 {
						css {
								fontSize = 1.5.rem
								marginBottom = 1.rem
						}
						+props.title
				}
				p {
						css {
								color = Color("#666")
								fontSize = 1.15.rem
								lineHeight = 1.5.rem
						}
						+props.description
				}
		}
}