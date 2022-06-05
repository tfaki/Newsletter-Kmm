package com.talhafaki.newsletter.data

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.observer.*
import io.ktor.client.request.*
import io.ktor.http.*

/**
 * Created by talhafaki on 5.06.2022.
 */

val httpClient = HttpClient {

    install(JsonFeature) {
        serializer = KotlinxSerializer()
    }

    install(Logging) {
        logger = object : Logger {
            override fun log(message: String) {
                println(message)
            }
        }
        level = LogLevel.ALL
        logger = Logger.DEFAULT
    }

    install(ResponseObserver) {
        onResponse { httpResponse ->
            println("Response: $httpResponse")
        }
    }

    install(DefaultRequest) {
        header(HttpHeaders.ContentType, ContentType.Application.Json)
    }

}