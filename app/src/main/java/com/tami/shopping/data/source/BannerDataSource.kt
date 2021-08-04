package com.tami.shopping.data.source

import com.tami.shopping.entity.BannerEntity

interface BannerDataSource {
    suspend fun getBannerEntityList(): List<BannerEntity>
}