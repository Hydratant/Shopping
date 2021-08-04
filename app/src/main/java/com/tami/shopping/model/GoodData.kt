package com.tami.shopping.model

import com.tami.shopping.entity.FavoriteGoodEntity


data class GoodData(
    val id: Int,            // Id
    val actualPrice: Int,   // 실제 가격
    val image: String,      // Image Url
    val isNew: Boolean,     // 신상 여부
    val name: String,       // 이름
    val price: Int,         // 판매 가격
    val sellCount: Int,     // 판매수
    val isFavorite: Boolean // 좋아요
) : HomeData() {
    companion object {
        val empty = GoodData(0, 0, "", true, "", 0, 0, true)
    }

    fun toFavoriteGoodEntity(): FavoriteGoodEntity =
        FavoriteGoodEntity(id, actualPrice, image, isNew, name, price, sellCount)
}