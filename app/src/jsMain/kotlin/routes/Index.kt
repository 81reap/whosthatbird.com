import components.Chat
import components.Nav
import components.SideBar
import csstype.*
import emotion.react.css
import kotlinx.coroutines.MainScope
import react.FC
import react.Props
import react.dom.html.ReactHTML.div

private val mainScope = MainScope()

val App = FC<Props> {
		val testMessages = arrayOf(
				Message(1, "user", "Why are they all looking at me?"),
				Message(2, "system", "Because my subconscious feels that someone else is creating this world. The more you change things, the quicker the projections start to converge on you."),
				Message(3, "user", "Converge?"),
				Message(4, "system", "It's the foreign nature of the dreamer. They attack like white blood cells fighting an infection."),
				Message(5, "user", "They're going to attack us?"),
				Message(6, "system", "No. Just you.")
		)

		val testContacts = arrayOf(
				Contact("Arthur", "No, it has to be more unique"),
				Contact("Ariadne", "No. Just you."),
				Contact("Eames", "dream a little bigger"),
				Contact("Yusef", "Depends on the dream."),
				Contact("Saito", "I bought the airline.")
		)

		div {
				css {
						fontFamily = FontFamily.monospace
						backgroundColor = NamedColor.white
						border = Border(2.px, LineStyle.solid, Color("black"))
						width = 100.pct
						maxWidth = 80.ch
						margin = Margin(0.px, Auto.auto)
				}

				Nav {
						header = "Who's that bird?"
				}

				div {
						css {
								display = Display.flex
						}
						SideBar {
								contacts = testContacts
						}
						Chat {
								messages = testMessages
						}
				}
		}
}
