package com.tami.shopping.data.repo

import com.tami.shopping.data.FakeData
import com.tami.shopping.model.GoodData
import com.tami.shopping.model.HomeData

class FakeHomeRepository : HomeRepository {
    override suspend fun getHomeDataList(): List<HomeData> =
        FakeData.fakeHomEntity.toHomeDataList(FakeData.fakeFavoriteList)

    override suspend fun getGoodDataListByLastId(lastId: Int): List<GoodData> =
        FakeData.fakeGooListEntity.goods.map { it.toGoodData() }
}