import web.dom.document
import web.html.HTML.div
//import kotlinx.coroutines.MainScope
import react.FC
import react.Props
import react.create
import react.dom.client.createRoot

//private val mainScope = MainScope()

val Router = FC<Props> {
//    BrowserRouter {
//        nav {
//            ul {
//                li { Link { +"Home"; attrs.to = "/" } }
//                li { Link { +"About"; attrs.to = "/about" } }
//            }
//        }
//        Routes {
//            Route { path = "/"; element = createElement(Home) }
//            Route { path = "/about"; element = createElement(About) }
//            Route { path = "*"; element = createElement(NotFound) }
//        }
//    }
}

fun main() {
    val container = document.createElement(div)
    container.style.apply {
        background = "red"
        width = "100%"
        height = "100%"
        overflow = "auto"
    }
    document.body.appendChild(container)
    createRoot(container).render(App.create())
}


