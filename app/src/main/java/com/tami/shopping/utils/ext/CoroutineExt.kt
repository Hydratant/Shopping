package com.tami.shopping.utils.ext

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Job

/**
 * Coroutine Job의 progress 사용을 편리하게 사용하기 위한 Ext
 */
fun Job.progress(isProgress: MutableLiveData<Boolean>) {
    isProgress.postValue(true)
    invokeOnCompletion { isProgress.postValue(false) }
}