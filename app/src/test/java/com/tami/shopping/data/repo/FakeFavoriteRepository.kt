package com.tami.shopping.data.repo

import androidx.lifecycle.LiveData
import com.tami.shopping.model.GoodData

class FakeFavoriteRepository : FavoriteRepository {
    override suspend fun getFavoriteList(): List<GoodData> {
        TODO()
    }

    override suspend fun getObserveFavoriteList(): LiveData<Result<List<GoodData>>> {
        TODO()
    }

    override suspend fun insertFavorite(goodData: GoodData) {
    }

    override suspend fun deleteFavoriteById(id: Int): Int = 1
}