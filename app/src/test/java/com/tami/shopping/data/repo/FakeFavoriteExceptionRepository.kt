package com.tami.shopping.data.repo

import androidx.lifecycle.LiveData
import com.tami.shopping.model.GoodData

class FakeFavoriteExceptionRepository : FavoriteRepository {
    override suspend fun getFavoriteList(): List<GoodData> {
        throw Exception("fakeException")
    }

    override suspend fun getObserveFavoriteList(): LiveData<Result<List<GoodData>>> {
        throw Exception("fakeException")
    }

    override suspend fun insertFavorite(goodData: GoodData) =
        throw Exception("fakeException")

    override suspend fun deleteFavoriteById(id: Int): Int =
        throw Exception("fakeException")
}