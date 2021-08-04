package com.tami.shopping.data.source

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

    override suspend fun insertFavorite(favoriteGoodEntity: FavoriteGoodEntity) =
        withContext(ioDisPatcher) { favoriteDao.insertFavorite(favoriteGoodEntity) }

    override suspend fun deleteFavorite(id: Int): Int =
        withContext(ioDisPatcher) { favoriteDao.deleteTaskById(id) }
}