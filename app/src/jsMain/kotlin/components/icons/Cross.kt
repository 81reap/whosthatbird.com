
import web.cssom.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.img

external interface CrossProps : Props {
		var size: Double
}
val Cross = FC<CrossProps> { props ->
		img {
				css {
						height = props.size.rem
						width = props.size.rem
				}
				src = "icons/GitHub.svg"
				alt = "GitHub icon"
		}
}
