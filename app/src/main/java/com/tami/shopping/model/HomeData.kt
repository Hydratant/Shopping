package com.tami.shopping.model


data class HomeData(
    val bannerList: List<BannerData>,
    val goodList: List<GoodData>
) {
    companion object {
        val empty = HomeData(listOf(), listOf())
    }
}

