package com.talhafaki.newsletter.android.di

import android.content.Context
import com.talhafaki.newsletter.android.NewsletterApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by talhafaki on 5.06.2022.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): NewsletterApp {
        return app as NewsletterApp
    }
}