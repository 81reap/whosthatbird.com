import web.dom.document
import web.html.HTML.div
//import kotlinx.coroutines.MainScope
import react.FC
import react.Props
import react.create
import react.dom.client.createRoot
import react.dom.html.ReactHTML.h3
import react.router.RouteObject
import react.router.RouterProvider
import react.router.dom.createBrowserRouter
import routes.Home
import routes.Index
import routes.Scan

//private val mainScope = MainScope()

fun main() {
		val container = document.createElement(div)
		container.style.apply {
				background = "red"
				width = "100%"
				height = "100%"
				overflow = "auto"
		}
		document.body.appendChild(container)
		createRoot(container).render(Router.create())
}


