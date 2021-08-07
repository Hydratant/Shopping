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

    fun toHomeDataList(favoriteList: List<FavoriteGoodEntity>): List<HomeData> {
        val bannerDataList = banners.map { it.toBannerData() }
        val goodsDataList = goods.map { entity ->
            val isFavorite = favoriteList.any { entity.id == it.id }
            entity.isFavorite = isFavorite
            entity.toGoodData()
        }
        return mutableListOf<HomeData>().apply {
            add(HomeBannerData(bannerDataList, 1))
            addAll(goodsDataList)
        }
    }
}

