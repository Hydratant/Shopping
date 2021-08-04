package com.tami.shopping.data.repo

import com.tami.shopping.model.BannerData

interface BannerRepository {
    suspend fun getBannerDataList(): List<BannerData>
}