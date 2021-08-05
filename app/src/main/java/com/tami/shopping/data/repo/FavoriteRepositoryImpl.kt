package com.tami.shopping.data.repo

import com.tami.shopping.data.source.FavoriteDataSource
import com.tami.shopping.model.GoodData

class FavoriteRepositoryImpl constructor(
    private val favoriteDataSource: FavoriteDataSource
) : FavoriteRepository {
    override suspend fun getFavoriteList(): List<GoodData> =
        favoriteDataSource.getFavoriteList().map { it.toGooData() }

    override suspend fun insertFavorite(goodData: GoodData) {
        favoriteDataSource.insertFavorite(goodData.toFavoriteGoodEntity())
    }

    override suspend fun deleteFavorite(id: Int): Int =
        favoriteDataSource.deleteFavorite(id)
}