package com.tami.shopping.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tami.shopping.domain.GetHomeDataUseCase
import com.tami.shopping.model.BannerData
import com.tami.shopping.model.GoodData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeDataUseCase: GetHomeDataUseCase
) : ViewModel() {

    private val _bannerDataList = MutableLiveData<List<BannerData>>()
    val bannerDataList: LiveData<List<BannerData>> get() = _bannerDataList

    private val _goodDataList = MutableLiveData<List<GoodData>>()
    val goodDataList: LiveData<List<GoodData>> get() = _goodDataList

    init {
        getHome()
    }

    fun getHome() {
        viewModelScope.launch {
            getHomeDataUseCase().fold(
                {
                    _bannerDataList.value = it.bannerList
                    _goodDataList.value = it.goodList
                },
                { Timber.e(it) }
            )
        }
    }
}