package components

import Contact
import web.cssom.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.aside
import react.dom.html.ReactHTML.div

external interface HistoryProps : Props {
		var contacts: Array<Contact>
}
val History = FC<HistoryProps> { props ->
		aside {
				css {
						width = 28.ch
						borderRight = Border(2.px, LineStyle.solid, Color("black"))
						padding = 0.5.rem
				}

				props.contacts.forEach { contact ->
						HistoryItem {
								this.contact = contact
						}
				}
		}
}

external interface HistoryItemProps : Props {
		var contact: Contact
}
val HistoryItem = FC<HistoryItemProps> { props ->
		div {
				css {
						marginBottom = 1.ch
						display = Display.flex
						alignItems = AlignItems.flexStart
						gap = 1.ch
				}

				div {
						css {
								width = 4.ch
								height = 4.ch
								backgroundColor = Color("#d1d1d1")
						}
				}

				div {
						div {
								css {
										fontWeight = FontWeight.bold
								}
								+props.contact.name
						}
						div {
								css {
										color = Color("#666")
										fontSize = 0.875.rem
										overflow = Overflow.hidden
										textOverflow = TextOverflow.ellipsis
										whiteSpace = WhiteSpace.nowrap
										maxWidth = 20.ch
								}
								+props.contact.status
						}
				}
		}
}