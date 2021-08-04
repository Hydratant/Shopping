package com.tami.shopping.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tami.shopping.domain.GetHomeDataListUseCase
import com.tami.shopping.model.HomeData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeDataListUseCase: GetHomeDataListUseCase
) : ViewModel() {

    private val _homeDataList = MutableLiveData<List<HomeData>>()
    val homeDataList: LiveData<List<HomeData>> get() = _homeDataList

    init {
        getHome()
    }

    fun getHome() {
        viewModelScope.launch {
            getHomeDataListUseCase().fold({ _homeDataList.value = it }, { Timber.e(it) })
        }
    }
}