package com.talhafaki.newsletter.data

import com.talhafaki.newsletter.domain.model.TopHeadlinesResponse
import io.ktor.client.request.*

/**
 * Created by talhafaki on 5.06.2022.
 */

const val API_KEY = "8ec5b28f7aca433bbea6ec7f32e584f2"
const val ENDPOINT = "https://newsapi.org/v2/top-headlines?country=tr&apiKey=$API_KEY"

suspend fun getTopHeadlines(): TopHeadlinesResponse {
    return httpClient.get(ENDPOINT)
}