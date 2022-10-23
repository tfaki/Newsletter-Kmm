package com.talhafaki.newsletter.data

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.android.Android

/**
 * Created by talhafaki on 18.06.2022.
 */
actual class KtorClientFactory {
    actual fun build(): HttpClientEngine {
        return Android.create()
    }
}