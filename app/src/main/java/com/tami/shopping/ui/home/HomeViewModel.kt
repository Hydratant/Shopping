package com.tami.shopping.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tami.shopping.domain.DeleteFavoriteByIdUseCase
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
    private val deleteFavoriteByIdUseCase: DeleteFavoriteByIdUseCase
) : ViewModel() {

    private val _homeDataList = ListLiveData<HomeData>()
    val homeDataList: LiveData<ArrayList<HomeData>> get() = _homeDataList

    private val _notifyItemChanged = MutableLiveData<Int>()
    val notifyItemChanged: LiveData<Int> get() = _notifyItemChanged

    val homeSpanSizeLookup = HomeSpanSizeLookup()
    val onFavoriteClick: ((GoodData, Int) -> Unit) =
        { data, position -> onFavoriteClick(data, position) }

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
            homeDataList.value?.last()?.let {
                if (it is GoodData) {
                    getGoodDataListUseCase(it.id).fold({ list ->
                        _homeDataList.addAll(list)
                    }, { exception -> Timber.e(exception) })
                }
            }
        }
    }

    private fun onFavoriteClick(goodData: GoodData, position: Int) {
        viewModelScope.launch {
            if (goodData.isFavorite) {
                deleteFavoriteByIdUseCase(goodData.id)
                    .fold({
                        goodData.isFavorite = false
                        _notifyItemChanged.value = position
                    }, { Timber.e(it) })
            } else {
                insertFavoriteUseCase(goodData)
                    .fold({
                        goodData.isFavorite = true
                        _notifyItemChanged.value = position
                    }, { Timber.e(it) })
            }
        }
    }
}