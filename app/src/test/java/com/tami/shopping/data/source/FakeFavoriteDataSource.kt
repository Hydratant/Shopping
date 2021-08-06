package com.tami.shopping.data.source

import androidx.lifecycle.LiveData
import com.tami.shopping.entity.FavoriteGoodEntity

class FakeFavoriteDataSource(
    var favoriteGoodEntityList: MutableList<FavoriteGoodEntity> = mutableListOf()
) : FavoriteDataSource {

    override suspend fun getFavoriteList(): List<FavoriteGoodEntity> {
        return favoriteGoodEntityList
    }

    override suspend fun insertFavorite(favoriteGoodEntity: FavoriteGoodEntity) {
        favoriteGoodEntityList.add(favoriteGoodEntity)
    }

    override suspend fun deleteFavoriteById(id: Int): Int {
        favoriteGoodEntityList.removeIf { it.id == id }
        return 1
    }

    override suspend fun getObserveFavoriteList(): LiveData<List<FavoriteGoodEntity>> {
        TODO("Not yet implemented")
    }
}