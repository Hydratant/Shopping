package com.tami.shopping.data.repo

import com.tami.shopping.model.GoodData
import com.tami.shopping.model.HomeData

class FakeHomeExceptionRepository : HomeRepository {
    override suspend fun getHomeDataList(): List<HomeData> =
        throw Exception("fakeException")

    override suspend fun getGoodDataListByLastId(lastId: Int): List<GoodData> {
        TODO("Not yet implemented")
    }
}