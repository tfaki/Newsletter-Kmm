package com.talhafaki.newsletter.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Created by talhafaki on 18.06.2022.
 */
fun <T> Flow<T>.asCommonFlow(): CommonFlow<T> = CommonFlow(this)

class CommonFlow<T>(private val origin: Flow<T>): Flow<T> by origin {
    fun collectCommon(
        coroutineScope: CoroutineScope? = null, // 'viewModelScope' on Android and 'nil' on iOS
        callback: (T) -> Unit, // callback on each emission
    ){
        onEach {
            callback(it)
        }.launchIn(coroutineScope ?: CoroutineScope(Dispatchers.Main))
    }
}