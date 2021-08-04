package com.tami.shopping.data.repo

import com.tami.shopping.model.HomeData

interface HomeRepository {
    suspend fun getHomeDataList(): List<HomeData>
}