package com.tami.shopping.data.source

import com.tami.shopping.data.FakeData
import com.tami.shopping.entity.GoodListEntity
import com.tami.shopping.entity.HomeEntity

class FakeHomeDataSource(
    private val fakeHomeEntity: HomeEntity = FakeData.fakeHomEntity,
    private val goodListEntity: GoodListEntity = FakeData.fakeGooListEntity
) : HomeDataSource {

    override suspend fun getHome(): HomeEntity = fakeHomeEntity

    override suspend fun getGoodListByLastId(lastId: Int): GoodListEntity =
        goodListEntity

}