package com.tami.shopping.data.remote

import com.tami.shopping.entity.GoodListEntity
import com.tami.shopping.entity.HomeEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ShoppingApi {

    @GET("api/home")
    suspend fun getHome(): HomeEntity

    @GET("api/home/goods")
    suspend fun getGoodList(
        @Query("lastId") lastId: Int
    ): GoodListEntity
}