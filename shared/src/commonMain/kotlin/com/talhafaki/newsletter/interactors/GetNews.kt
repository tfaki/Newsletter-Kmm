package com.talhafaki.newsletter.interactors

import com.talhafaki.newsletter.data.RemoteClient
import com.talhafaki.newsletter.domain.model.TopHeadlinesResponse
import com.talhafaki.newsletter.util.CommonFlow
import com.talhafaki.newsletter.util.asCommonFlow
import kotlinx.coroutines.flow.flow

/**
 * Created by talhafaki on 18.06.2022.
 */
class GetNews(
    private val remoteClient: RemoteClient
) {
    fun execute(): CommonFlow<TopHeadlinesResponse> = flow {
        emit(remoteClient.getTopHeadlines())
    }.asCommonFlow()
}