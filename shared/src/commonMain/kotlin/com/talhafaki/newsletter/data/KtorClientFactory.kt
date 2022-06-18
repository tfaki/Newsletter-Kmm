package com.talhafaki.newsletter.data

import io.ktor.client.*

/**
 * Created by talhafaki on 18.06.2022.
 */
expect class KtorClientFactory {
    fun build(): HttpClient
}