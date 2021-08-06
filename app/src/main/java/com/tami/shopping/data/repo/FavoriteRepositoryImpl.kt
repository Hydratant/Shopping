package com.tami.shopping.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.tami.shopping.data.source.FavoriteDataSource
import com.tami.shopping.model.GoodData

class FavoriteRepositoryImpl constructor(
    private val favoriteDataSource: FavoriteDataSource
) : FavoriteRepository {
    override suspend fun getFavoriteList(): List<GoodData> =
        favoriteDataSource.getFavoriteList().map { it.toGoodData() }

    override suspend fun getObserveFavoriteList(): LiveData<Result<List<GoodData>>> =
        favoriteDataSource.getObserveFavoriteList().map {
            Result.success(it.map { entity -> entity.toGoodData() })
        }

    override suspend fun insertFavorite(goodData: GoodData) {
        favoriteDataSource.insertFavorite(goodData.toFavoriteGoodEntity())
    }

    override suspend fun deleteFavoriteById(id: Int): Int =
        favoriteDataSource.deleteFavoriteById(id)
}