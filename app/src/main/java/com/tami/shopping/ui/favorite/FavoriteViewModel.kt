package com.tami.shopping.ui.favorite

import androidx.lifecycle.*
import com.tami.shopping.R
import com.tami.shopping.base.Event
import com.tami.shopping.domain.ObserveGetFavoriteListUseCase
import com.tami.shopping.model.GoodData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val observeGetFavoriteListUseCase: ObserveGetFavoriteListUseCase
) : ViewModel() {
    private val _favoriteList: LiveData<Result<List<GoodData>>> = liveData {
        emitSource(observeGetFavoriteListUseCase())
    }
    val favoriteList: LiveData<List<GoodData>> = _favoriteList.map {
        it.fold({ list -> return@map list }, {
            showErrorMessage()
            return@map emptyList()
        })
    }

    private val _showErrorMessage = MutableLiveData<Event<Int>>()
    val showErrorMessage: LiveData<Event<Int>> get() = _showErrorMessage

    private fun showErrorMessage(message: Int = R.string.common_error_message) {
        _showErrorMessage.value = Event(message)
    }
}