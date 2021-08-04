package com.tami.shopping.data.source

import com.tami.shopping.entity.GoodEntity

interface GoodDataSource {
    suspend fun getHomeGoodEntityList(): List<GoodEntity>
}