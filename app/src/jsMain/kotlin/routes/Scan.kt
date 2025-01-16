package routes

import Contact
import Message
import components.Chat
import components.History
import web.cssom.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML

external interface ScanProps : Props {
		var contacts: Array<Contact>
		var messages: Array<Message>
}
val Scan = FC<ScanProps> { props ->
		ReactHTML.div {
				css {
						display = Display.flex
				}
				History {
						contacts = props.contacts
				}
				Chat {
						messages = props.messages
				}
		}
}