package routes

import react.FC
import react.Props
import react.dom.html.ReactHTML

val NotFound = FC<Props> {
		ReactHTML.div {
				+"404"
		}
}