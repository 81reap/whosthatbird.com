package routes

import Message
import components.Chat as ChatComponent
import web.cssom.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML

val Chat = FC<Props> {
		ReactHTML.div {
				css {
						display = Display.flex
						flex = Flex.content
				}
				ChatComponent { }
		}
}
