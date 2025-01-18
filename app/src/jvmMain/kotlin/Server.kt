// src/jvmMain/kotlin/Server.kt
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import io.ktor.server.routing.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

// You already have these in Data.kt
val testMessages = arrayOf(
		Message(1, "user", "Why are they all looking at me?"),
		Message(2, "system", "Because my subconscious feels that someone else is creating this world. The more you change things, the quicker the projections start to converge on you."),
		Message(3, "user", "Converge?"),
		Message(4, "system", "It's the foreign nature of the dreamer. They attack like white blood cells fighting an infection."),
		Message(5, "user", "They're going to attack us?"),
		Message(6, "system", "No. Just you.")
)

val testContacts = arrayOf(
		Contact("Arthur", "No, it has to be more unique"),
		Contact("Ariadne", "No. Just you."),
		Contact("Eames", "dream a little bigger"),
		Contact("Yusef", "Depends on the dream."),
		Contact("Saito", "I bought the airline.")
)

fun main() {
		embeddedServer(Netty, port = 8080) {
				install(ContentNegotiation) {
						json()  // ktor-serialization-kotlinx-json
				}
				routing {
//						static("/") {
//								resources("static")
//								defaultResource("static/index.html")
//						}
						get("/api/messages") {
								// Return messages as JSON
								call.respond(testMessages)
						}
						get("/api/contacts") {
								// Return contacts as JSON
								call.respond(testContacts)
						}
				}
		}.start(wait = true)
}
