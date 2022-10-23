package com.talhafaki.newsletter.data

import io.ktor.client.engine.HttpClientEngine

/**
 * Created by talhafaki on 18.06.2022.
 */
expect class KtorClientFactory() {
    fun build(): HttpClientEngine
}