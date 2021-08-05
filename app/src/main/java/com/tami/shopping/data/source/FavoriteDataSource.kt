package com.tami.shopping.data.source

import androidx.lifecycle.LiveData
import com.tami.shopping.entity.FavoriteGoodEntity

interface FavoriteDataSource {
    suspend fun getFavoriteList(): List<FavoriteGoodEntity>
    suspend fun getObserveFavoriteList(): LiveData<List<FavoriteGoodEntity>>
    suspend fun insertFavorite(favoriteGoodEntity: FavoriteGoodEntity)
    suspend fun deleteFavorite(id: Int): Int
}