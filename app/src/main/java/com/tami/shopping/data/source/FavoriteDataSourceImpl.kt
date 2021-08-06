package com.tami.shopping.data.source

import androidx.lifecycle.LiveData
import com.tami.shopping.data.local.FavoriteDao
import com.tami.shopping.entity.FavoriteGoodEntity
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavoriteDataSourceImpl constructor(
    private val favoriteDao: FavoriteDao,
    private val ioDisPatcher: CoroutineDispatcher = Dispatchers.IO
) : FavoriteDataSource {
    override suspend fun getFavoriteList(): List<FavoriteGoodEntity> =
        withContext(ioDisPatcher) { favoriteDao.getFavoriteList() }

    override suspend fun getObserveFavoriteList(): LiveData<List<FavoriteGoodEntity>> =
        withContext(ioDisPatcher) { favoriteDao.getObserveFavoriteList() }

    override suspend fun insertFavorite(favoriteGoodEntity: FavoriteGoodEntity) =
        withContext(ioDisPatcher) { favoriteDao.insertFavorite(favoriteGoodEntity) }

    override suspend fun deleteFavoriteById(id: Int): Int =
        withContext(ioDisPatcher) { favoriteDao.deleteFavoriteById(id) }
}