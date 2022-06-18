package com.talhafaki.newsletter.android.di

import com.talhafaki.newsletter.data.KtorClientFactory
import com.talhafaki.newsletter.data.RemoteClient
import com.talhafaki.newsletter.data.RemoteClientImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

/**
 * Created by talhafaki on 5.06.2022.
 */

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return KtorClientFactory().build()
    }

    @Singleton
    @Provides
    fun provideRemoteClient(httpClient: HttpClient): RemoteClient {
        return RemoteClientImpl(httpClient = httpClient)
    }
}