package com.talhafaki.newsletter.data

import com.talhafaki.newsletter.domain.model.TopHeadlinesResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

/**
 * Created by talhafaki on 18.06.2022.
 */

class RemoteClientImpl : RemoteClient {

    private fun createJson() = Json { isLenient = true; ignoreUnknownKeys = true }

    private val httpClient: HttpClient = HttpClient(KtorClientFactory().build()) {
        install(ContentNegotiation) {
            json(createJson())
        }
    }

    override suspend fun getTopHeadlines(): TopHeadlinesResponse {
        return httpClient.get {
            url(BASE_URL+ENDPOINT)
            parameter("country", "tr")
            parameter("apiKey", "8ec5b28f7aca433bbea6ec7f32e584f2")
        }.body()
    }
}

const val BASE_URL = "https://newsapi.org/v2"
const val ENDPOINT = "/top-headlines"