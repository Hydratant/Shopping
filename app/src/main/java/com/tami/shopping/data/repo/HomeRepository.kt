package com.tami.shopping.data.repo

import com.tami.shopping.model.GoodData
import com.tami.shopping.model.HomeData

interface HomeRepository {
    suspend fun getHomeDataList(): List<HomeData>
    suspend fun getGoodDataList(lastId: Int): List<GoodData>
}