package com.tami.shopping.data.repo

import androidx.lifecycle.LiveData
import com.tami.shopping.model.GoodData

interface FavoriteRepository {
    suspend fun getFavoriteList(): List<GoodData>
    suspend fun getObserveFavoriteList(): LiveData<Result<List<GoodData>>>
    suspend fun insertFavorite(goodData: GoodData)
    suspend fun deleteFavorite(id: Int): Int
}