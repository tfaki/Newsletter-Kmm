package com.talhafaki.newsletter.di

import com.talhafaki.newsletter.data.KtorClientFactory
import com.talhafaki.newsletter.data.RemoteClient
import com.talhafaki.newsletter.data.RemoteClientImpl

/**
 * Created by talhafaki on 18.06.2022.
 */
class NetworkModule {

    val remoteClient: RemoteClient by lazy {
        RemoteClientImpl(
            httpClient = KtorClientFactory().build(),
        )
    }
}