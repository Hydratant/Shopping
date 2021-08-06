package com.tami.shopping.data.source

import com.tami.shopping.data.remote.ShoppingApi
import com.tami.shopping.entity.GoodListEntity
import com.tami.shopping.entity.HomeEntity

class HomeDataSourceImpl constructor(
    private val shoppingApi: ShoppingApi
) : HomeDataSource {
    override suspend fun getHome(): HomeEntity = shoppingApi.getHome()
    override suspend fun getGoodListByLastId(lastId: Int): GoodListEntity =
        shoppingApi.getGoodList(lastId)
}