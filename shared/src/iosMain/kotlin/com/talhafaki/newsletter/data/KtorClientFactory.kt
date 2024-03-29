package com.talhafaki.newsletter.data

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.ios.Ios

/**
 * Created by talhafaki on 18.06.2022.
 */

actual class KtorClientFactory {
    actual fun build(): HttpClientEngine {
        return Ios.create()
    }
}