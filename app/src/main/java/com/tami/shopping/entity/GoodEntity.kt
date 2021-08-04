package com.tami.shopping.entity

import com.tami.shopping.model.GoodData

data class GoodEntity(
    val id: Int,                        // Id
    val actual_price: Int,              // 실제 가격
    val image: String,                  // Image Url
    val is_new: Boolean,                // 신상 여부
    val name: String,                   // 이름
    val price: Int,                     // 판매 가격
    val sell_count: Int,                // 판매수
    val isFavorite: Boolean = false     // 좋아요
) {
    companion object {
        val empty = GoodEntity(0, 0, "", true, "", 0, 0)
    }

    fun toGoodData(): GoodData =
        GoodData(id, actual_price, image, is_new, name, price, sell_count, false)

}
