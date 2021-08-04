package com.tami.shopping.data.source

import com.tami.shopping.data.local.HomeCache
import com.tami.shopping.data.remote.ShoppingApi
import com.tami.shopping.entity.BannerEntity

class BannerDataSourceImpl constructor(
    private val shoppingApi: ShoppingApi,
    private val homeCache: HomeCache
) : BannerDataSource {
    override suspend fun getBannerEntityList(): List<BannerEntity> =
        homeCache.get()?.banners ?: run {
            val remoteHomeEntity = shoppingApi.getHome()
            homeCache.put(remoteHomeEntity)
            remoteHomeEntity.banners
        }
}