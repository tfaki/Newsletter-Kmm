package com.talhafaki.newsletter.data

import com.talhafaki.newsletter.domain.model.TopHeadlinesResponse
import io.ktor.client.*
import io.ktor.client.request.*

/**
 * Created by talhafaki on 18.06.2022.
 */

class RemoteClientImpl(private val httpClient: HttpClient): RemoteClient {
    override suspend fun getTopHeadlines(): TopHeadlinesResponse {
        return httpClient.get(ENDPOINT)
    }
}

const val ENDPOINT = "https://newsapi.org/v2/top-headlines?country=tr&apiKey=8ec5b28f7aca433bbea6ec7f32e584f2"