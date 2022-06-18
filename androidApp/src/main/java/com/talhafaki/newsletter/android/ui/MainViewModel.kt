package com.talhafaki.newsletter.android.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.talhafaki.newsletter.domain.model.TopHeadlinesResponse
import com.talhafaki.newsletter.interactors.GetNews
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created by talhafaki on 5.06.2022.
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getNews: GetNews
) : ViewModel() {

    val state: MutableState<TopHeadlinesResponse> = mutableStateOf(TopHeadlinesResponse())

    init {
        getNews()
    }

    private fun getNews() {
        getNews.execute().collectCommon {
            state.value = it
        }
    }

}