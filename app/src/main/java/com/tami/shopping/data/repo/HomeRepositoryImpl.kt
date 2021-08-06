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

    override suspend fun getGoodDataListByLastId(lastId: Int): List<GoodData> =
        homeDataSource.getGoodListByLastId(lastId).goods.map { it.toGoodData() }
}