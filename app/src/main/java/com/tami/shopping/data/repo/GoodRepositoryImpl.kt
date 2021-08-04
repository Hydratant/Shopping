package com.tami.shopping.data.repo

import com.tami.shopping.data.source.GoodDataSource
import com.tami.shopping.model.GoodData

class GoodRepositoryImpl constructor(
    private val goodDataSource: GoodDataSource
) : GoodRepository {
    override suspend fun getHomeGoodDataList(): List<GoodData> =
        goodDataSource.getHomeGoodEntityList().map { it.toGoodData() }
}