import kotlinx.coroutines.MainScope
import react.FC
import react.Props
import react.dom.html.ReactHTML.h1

private val mainScope = MainScope()

val App = FC<Props> {
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

    Chat {
        header = "Who's that bird?"
        messages = testMessages
        contacts = testContacts
    }
}
