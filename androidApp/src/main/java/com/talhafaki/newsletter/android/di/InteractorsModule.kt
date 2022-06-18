package com.talhafaki.newsletter.android.di

import com.talhafaki.newsletter.data.RemoteClient
import com.talhafaki.newsletter.interactors.GetNews
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by talhafaki on 18.06.2022.
 */
@Module
@InstallIn(SingletonComponent::class)
object InteractorsModule {

    @Singleton
    @Provides
    fun provideGetNews(
        remoteClient: RemoteClient
    ): GetNews {
        return GetNews(
            remoteClient = remoteClient
        )
    }
}