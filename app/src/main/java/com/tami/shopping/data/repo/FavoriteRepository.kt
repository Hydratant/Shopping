package com.tami.shopping.data.repo

import com.tami.shopping.model.GoodData

interface FavoriteRepository {
    suspend fun getFavoriteList(): List<GoodData>
    suspend fun insertFavorite(goodData: GoodData)
    suspend fun deleteFavorite(id: Int): Int
}