import kotlinx.serialization.Serializable;

@Serializable
data class Message(
		val id: Int,
		val sender: String,
		val text: String,
		val image: String? = null,
)

@Serializable
data class Contact(
		val name: String,
		val status: String,
)
