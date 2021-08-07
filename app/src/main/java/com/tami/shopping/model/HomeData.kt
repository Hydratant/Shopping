package com.tami.shopping.model

sealed class HomeData

data class HomeBannerData(
    val bannerDataList: List<BannerData>,
    var currentPage: Int = 1
) : HomeData() {
    val totalCount: Int
        get() {
            return bannerDataList.size
        }
}
