package com.tami.shopping.data

import com.tami.shopping.entity.*

object FakeData {

    private val fakeBannerEntity = BannerEntity(0, "image")
    private val fakeBannerEntity2 = BannerEntity(1, "image2")
    private val fakeBannerEntity3 = BannerEntity(2, "image3")
    private val fakeBannerList =
        mutableListOf(fakeBannerEntity, fakeBannerEntity2, fakeBannerEntity3)

    private val fakeGoodEntity = GoodEntity(0, 1000, "image", true, "name", 1000, 10)
    private val fakeGoodEntity2 = GoodEntity(1, 2000, "image2", true, "name2", 2000, 20)
    private val fakeGoodEntity3 = GoodEntity(2, 3000, "image3", true, "name3", 3000, 30)

    private val fakeGoodList =
        mutableListOf(fakeGoodEntity, fakeGoodEntity2, fakeGoodEntity3)

    val fakeHomEntity = HomeEntity(fakeBannerList, fakeGoodList)
    val fakeGooListEntity = GoodListEntity(fakeGoodList)


    private val fakeFavoriteGoodEntity =
        FavoriteGoodEntity(0, 1000, "image", true, "name", 1000, 10)

    val fakeFavoriteList = mutableListOf(fakeFavoriteGoodEntity)
}