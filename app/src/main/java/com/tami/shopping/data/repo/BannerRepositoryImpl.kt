package com.tami.shopping.data.repo

import com.tami.shopping.data.source.BannerDataSource
import com.tami.shopping.model.BannerData

class BannerRepositoryImpl constructor(
    private val bannerDataSource: BannerDataSource
) : BannerRepository {
    override suspend fun getBannerDataList(): List<BannerData> =
        bannerDataSource.getBannerEntityList().map { it.toBannerData() }
}