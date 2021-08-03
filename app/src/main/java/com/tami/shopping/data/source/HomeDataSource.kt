package com.tami.shopping.data.source

import com.tami.shopping.entity.HomeEntity

interface HomeDataSource {
    suspend fun getHome(): HomeEntity
}