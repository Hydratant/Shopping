package com.tami.shopping.data.remote

import com.tami.shopping.entity.GoodListEntity
import com.tami.shopping.entity.HomeEntity
import retrofit2.http.GET
import retrofit2.http.Query


interface ShoppingApi {

    /**
     * Home 전체 Data를 가져온다
     */
    @GET("api/home")
    suspend fun getHome(): HomeEntity

    /**
     *  Good 새로운 목록을 불러온다.
     *
     *  @param lastId 보여지고 있는 목록중 마지막 Id
     */
    @GET("api/home/goods")
    suspend fun getGoodList(
        @Query("lastId") lastId: Int
    ): GoodListEntity
}