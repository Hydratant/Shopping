package com.tami.shopping.data.repo

import com.tami.shopping.model.GoodData

interface GoodRepository {
    suspend fun getHomeGoodDataList(): List<GoodData>
}