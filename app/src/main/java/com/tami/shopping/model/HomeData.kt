package com.tami.shopping.model

sealed class HomeData

data class HomeBannerData(
    val bannerDataList: List<BannerData>
) : HomeData() {
    val totalPage: Int
        get() {
            return bannerDataList.size
        }
    var currentPage: Int = 1
}
