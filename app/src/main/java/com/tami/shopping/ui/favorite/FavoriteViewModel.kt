package com.tami.shopping.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tami.shopping.domain.GetFavoriteListUseCase
import com.tami.shopping.model.GoodData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val getFavoriteListUseCase: GetFavoriteListUseCase
) : ViewModel() {
    private val _favoriteList = MutableLiveData<List<GoodData>>(emptyList())
    val favoriteList: LiveData<List<GoodData>> get() = _favoriteList


    init {
        getList()
    }

    fun getList() {
        viewModelScope.launch {
            getFavoriteListUseCase().fold(
                { _favoriteList.value = it },
                { Timber.e(it) }
            )
        }
    }
}