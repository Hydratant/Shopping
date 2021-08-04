package com.tami.shopping.data.source

import com.tami.shopping.data.local.HomeCache
import com.tami.shopping.data.remote.ShoppingApi
import com.tami.shopping.entity.GoodEntity

class GoodDataSourceImpl constructor(
    private val shoppingApi: ShoppingApi,
    private val homeCache: HomeCache
) : GoodDataSource {
    override suspend fun getHomeGoodEntityList(): List<GoodEntity> {
        return homeCache.get()?.goods ?: run {
            val remoteHomeEntity = shoppingApi.getHome()
            homeCache.put(remoteHomeEntity)
            remoteHomeEntity.goods
        }
    }
}