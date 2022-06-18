package com.talhafaki.newsletter.di

import com.talhafaki.newsletter.data.RemoteClient
import com.talhafaki.newsletter.interactors.GetNews

/**
 * Created by talhafaki on 18.06.2022.
 */
class GetNewsModule(remoteClient: RemoteClient) {

    val getNews: GetNews by lazy {
        GetNews(remoteClient = remoteClient)
    }
}