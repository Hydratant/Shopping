package com.tami.shopping.data.remote

import com.tami.shopping.entity.HomeEntity
import retrofit2.http.GET

interface ShoppingApi {

    @GET("api/home")
    suspend fun getHome(): HomeEntity
}