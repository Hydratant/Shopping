package com.tami.shopping.data.repo

import com.tami.shopping.data.source.FavoriteDataSource
import com.tami.shopping.data.source.HomeDataSource
import com.tami.shopping.model.GoodData
import com.tami.shopping.model.HomeData

class HomeRepositoryImpl constructor(
    private val homeDataSource: HomeDataSource,
    private val favoriteDataSource: FavoriteDataSource
) : HomeRepository {
    override suspend fun getHomeDataList(): List<HomeData> =
        homeDataSource.getHome().toHomeDataList(favoriteDataSource.getFavoriteList())

    override suspend fun getGoodDataList(lastId: Int): List<GoodData> =
        homeDataSource.getGoodList(lastId).goods.map { it.toGoodData() }
}