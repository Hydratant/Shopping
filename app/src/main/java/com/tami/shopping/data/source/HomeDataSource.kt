package com.tami.shopping.data.source

import com.tami.shopping.entity.GoodListEntity
import com.tami.shopping.entity.HomeEntity

interface HomeDataSource {
    suspend fun getHome(): HomeEntity
    suspend fun getGoodListByLastId(lastId: Int): GoodListEntity
}