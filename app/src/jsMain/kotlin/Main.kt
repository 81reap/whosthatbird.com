import components.Nav
import components.WIP
import web.cssom.*
import emotion.react.css
import web.dom.document
import web.html.HTML.div
import kotlinx.coroutines.MainScope
import react.Component
import react.FC
import react.Props
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML
import react.router.Outlet
import react.router.RouteObject
import react.router.RouterProvider
import react.router.dom.createHashRouter
import routes.Home
import routes.Index
import routes.NotFound
import routes.Scan

private val mainScope = MainScope()

val Router = FC<Props> {
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

		RouterProvider {
				router = createHashRouter(
						arrayOf(
								RouteObject(
										path = "/",
										Component = Root,
										children = arrayOf(
												RouteObject(
														index = true,
														Component = Home,
												),
												RouteObject(
														path = "scan",
														Component = WIP
//														element = Scan.create() {
//																contacts = testContacts
//																messages = testMessages
//														},
												),
												RouteObject(
														path = "index",
														Component = WIP,
												)
										)
								),
								RouteObject(
										path = "*",
										Component = NotFound,
								)
						)
				)
		}
}

val Root = FC<Props> {
		ReactHTML.div {
				css {
						fontFamily = FontFamily.monospace
						backgroundColor = NamedColor.white
						border = Border(2.px, LineStyle.solid, Color("black"))
						margin = 1.ch
						height = "calc(100vh - 3ch)".unsafeCast<Height>()
						overflow = Overflow.hidden
						display = Display.flex
						flexDirection = FlexDirection.column
				}

				ReactHTML.div {
						css {
								flexShrink = number(0.0)
						}
						Nav {
								header = "¿Who's that bird?"
						}
				}

				ReactHTML.div {
						css {
								flexGrow = number(1.0)
								overflow = "auto".unsafeCast<Overflow>()
								padding = 1.ch
						}

						Outlet()
				}
		}
}

fun main() {
		val container = document.createElement(div)
		container.style.apply {
				background = "#90EE90"
				width = "100%"
				height = "100%"
				overflow = "auto"
		}
		document.body.appendChild(container)
		createRoot(container).render(Router.create())
}


