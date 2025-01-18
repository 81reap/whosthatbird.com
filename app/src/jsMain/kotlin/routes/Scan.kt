package routes

import components.Chat
import components.History
import web.cssom.*
import emotion.react.css
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import react.FC
import react.Props
import react.dom.html.ReactHTML
import react.useEffectOnce
import react.useState

import Contact
import Message
import ApiClient

object ScanService {
		suspend fun getMessages(): Array<Message> {
				return ApiClient.get("/api/messages")
		}

		suspend fun getContacts(): Array<Contact> {
				return ApiClient.get("/api/contacts")
		}
}

val Scan = FC<Props> {
		val (contacts, setContacts) = useState<Array<Contact>>(emptyArray())
		val (messages, setMessages) = useState<Array<Message>>(emptyArray())

		val scope = MainScope()

		useEffectOnce {
				scope.launch {
						try {
								val fetchedContacts = ScanService.getContacts()
								val fetchedMessages = ScanService.getMessages()
								setContacts(fetchedContacts)
								setMessages(fetchedMessages)
						} catch (e: Exception) {
								console.error("Failed to fetch data", e)
						}
				}
		}

		ReactHTML.div {
				css {
						display = Display.flex
				}
				History {
						this.contacts = contacts
				}
				Chat {
						this.messages = messages
				}
		}
}