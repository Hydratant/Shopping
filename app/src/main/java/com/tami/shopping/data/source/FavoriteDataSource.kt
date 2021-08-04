package com.tami.shopping.data.source

import com.tami.shopping.entity.FavoriteGoodEntity

interface FavoriteDataSource {
    suspend fun getFavoriteList(): List<FavoriteGoodEntity>
    suspend fun insertFavorite(favoriteGoodEntity: FavoriteGoodEntity)
    suspend fun deleteFavorite(id: Int): Int
}