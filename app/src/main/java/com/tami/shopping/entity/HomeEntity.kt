package com.tami.shopping.entity

import com.tami.shopping.model.HomeData

data class HomeEntity(
    val banners: List<BannerEntity>,
    val goods: List<GoodEntity>
) {

    companion object {
        val empty = HomeEntity(listOf(), listOf())
    }

    fun toHomeData(): HomeData =
        HomeData(
            banners.map { it.toBannerData() },
            goods.map { it.toGoodData() }
        )
}

