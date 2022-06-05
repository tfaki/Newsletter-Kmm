package com.talhafaki.newsletter.data

import com.talhafaki.newsletter.domain.model.TopHeadlinesResponse

/**
 * Created by talhafaki on 5.06.2022.
 */
class TopHeadlineRepository {

    suspend fun getTopHeadlinesData(): TopHeadlinesResponse {
        return getTopHeadlines()
    }
}