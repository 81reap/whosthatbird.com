import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.js.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

val httpClient = HttpClient(Js) {
		install(ContentNegotiation) {
				json(Json { ignoreUnknownKeys = true })
		}
}

object ApiClient {
		suspend inline fun <reified T> get(path: String): T {
				return httpClient.get("http://localhost:8080/"+path).body()
		}

		suspend inline fun <reified T> post(path: String, data: Any): T {
				return httpClient.post("http://localhost:8080/"+path) {
						setBody(data)
				}.body()
		}

		// todo :: Add other HTTP methods like put, delete, etc.
}
