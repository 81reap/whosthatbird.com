
import web.cssom.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.img

external interface GitHubProps : Props {
		var size: Double
}
val GitHub = FC<GitHubProps> { props ->
		img {
				css {
						height = props.size.rem
						width = props.size.rem
				}
				src = "icons/GitHub.svg"
				alt = "GitHub icon"
		}
}
