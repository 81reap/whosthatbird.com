
import web.cssom.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.img

external interface ImageProps : Props {
		var size: Double
}
val Image = FC<ImageProps> { props ->
		img {
				css {
						height = props.size.rem
						width = props.size.rem
				}
				src = "icons/GitHub.svg"
				alt = "GitHub icon"
		}
}
