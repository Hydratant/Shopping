package com.tami.shopping.data.repo

import com.tami.shopping.data.source.HomeDataSource
import com.tami.shopping.model.HomeData

class HomeRepositoryImpl constructor(
    private val homeDataSource: HomeDataSource
) : HomeRepository {
    override suspend fun getHomeDataList(): List<HomeData> =
        homeDataSource.getHome().toHomeDataList()
}