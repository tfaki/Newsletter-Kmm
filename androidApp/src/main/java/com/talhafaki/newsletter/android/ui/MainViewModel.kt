package com.talhafaki.newsletter.android.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.talhafaki.newsletter.data.TopHeadlineRepository
import com.talhafaki.newsletter.domain.model.TopHeadlinesResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by talhafaki on 5.06.2022.
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val topHeadlineRepository: TopHeadlineRepository
) : ViewModel() {

    fun getTopHeadlines(): LiveData<TopHeadlinesResponse> {
        val ld = MutableLiveData<TopHeadlinesResponse>()

        viewModelScope.launch(Dispatchers.IO) {
            val response = topHeadlineRepository.getTopHeadlinesData()
            ld.postValue(response)
        }
        return ld
    }

}