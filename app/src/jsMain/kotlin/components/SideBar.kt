package components

import Contact
import csstype.*
import emotion.react.css
import react.FC
import react.Props
import react.dom.html.ReactHTML.aside
import react.dom.html.ReactHTML.div

external interface SideBarProps : Props {
		var contacts: Array<Contact>
}

val SideBar = FC<SideBarProps> { props ->
		aside {
				css {
						width = 28.ch
						borderRight = Border(2.px, LineStyle.solid, Color("black"))
						padding = 0.5.rem
				}

				props.contacts.forEach { contact ->
						div {
								css {
										marginBottom = 1.rem
										display = Display.flex
										alignItems = AlignItems.flexStart
										gap = 0.5.rem
								}

								div {
										css {
												width = 1.5.rem
												height = 1.5.rem
												backgroundColor = Color("#d1d1d1")
										}
								}

								div {
										div {
												css {
														fontWeight = FontWeight.bold
												}
												+contact.name
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
												+contact.status
										}
								}
						}
				}
		}
}