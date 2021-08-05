package com.tami.shopping.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tami.shopping.domain.DeleteFavoriteUseCase
import com.tami.shopping.domain.GetGoodDataListUseCase
import com.tami.shopping.domain.GetHomeDataListUseCase
import com.tami.shopping.domain.InsertFavoriteUseCase
import com.tami.shopping.model.GoodData
import com.tami.shopping.model.HomeData
import com.tami.shopping.utils.ListLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getHomeDataListUseCase: GetHomeDataListUseCase,
    private val getGoodDataListUseCase: GetGoodDataListUseCase,
    private val insertFavoriteUseCase: InsertFavoriteUseCase,
    private val deleteFavoriteUseCase: DeleteFavoriteUseCase
) : ViewModel() {

    private val _homeDataList = ListLiveData<HomeData>()
    val homeDataList: LiveData<ArrayList<HomeData>> get() = _homeDataList

    val homeSpanSizeLookup = HomeSpanSizeLookup()
    val onFavoriteClick: ((GoodData) -> Unit) = { onFavoriteClick(it) }

    init {
        getHome()
    }

    fun getHome() {
        viewModelScope.launch {
            getHomeDataListUseCase().fold({
                _homeDataList.clear(false)
                _homeDataList.addAll(it)
            }, { Timber.e(it) })
        }
    }

    fun getGoodDataList() {
        viewModelScope.launch {
            getGoodDataListUseCase(10).fold({
                _homeDataList.addAll(it)
            }, { Timber.e(it) })
        }
    }

    private fun onFavoriteClick(goodData: GoodData) {
        viewModelScope.launch {
            if (goodData.isFavorite) {
                deleteFavoriteUseCase(goodData.id)
                    .fold({ Timber.i("delete Success") },
                        { Timber.e(it) })
            } else {
                insertFavoriteUseCase(goodData)
                    .fold({ Timber.i("insert Success") },
                        { Timber.e(it) })
            }
        }
    }
}