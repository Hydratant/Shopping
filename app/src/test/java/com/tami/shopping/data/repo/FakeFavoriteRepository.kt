package com.tami.shopping.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tami.shopping.data.FakeData
import com.tami.shopping.model.GoodData

class FakeFavoriteRepository(
    fakeFavoriteData: List<GoodData> = FakeData.fakeFavoriteList.map { it.toGoodData() }
) : FavoriteRepository {

    private val observableGoodList = MutableLiveData<Result<List<GoodData>>>()

    init {
        observableGoodList.value = Result.success(fakeFavoriteData)
    }

    override suspend fun getFavoriteList(): List<GoodData> {
        TODO()
    }

    override suspend fun getObserveFavoriteList(): LiveData<Result<List<GoodData>>> =
        observableGoodList

    override suspend fun insertFavorite(goodData: GoodData) {
    }

    override suspend fun deleteFavoriteById(id: Int): Int = 1
}