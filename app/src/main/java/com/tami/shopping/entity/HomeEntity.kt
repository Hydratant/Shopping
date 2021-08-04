package com.tami.shopping.entity

import com.tami.shopping.model.HomeBannerData
import com.tami.shopping.model.HomeData

data class HomeEntity(
    val banners: List<BannerEntity>,
    val goods: List<GoodEntity>
) {

    companion object {
        val empty = HomeEntity(listOf(), listOf())
    }

    fun toHomeDataList(): List<HomeData> {
        val bannerDataList = banners.map { it.toBannerData() }
        val goodsDataList = goods.map { it.toGoodData() }
        return mutableListOf<HomeData>().apply {
            add(HomeBannerData(bannerDataList))
            addAll(goodsDataList)
        }
    }
}

