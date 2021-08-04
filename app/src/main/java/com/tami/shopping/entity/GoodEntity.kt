package com.tami.shopping.entity

import com.tami.shopping.model.GoodData

data class GoodEntity(
    val id: Int,            // Id
    val actual_price: Int,  // 세일 가격
    val image: String,      // Image Url
    val is_new: Boolean,    // 신상 여부
    val name: String,       // 이름
    val price: Int,         // 가격
    val sell_count: Int     // 판매수
) {
    companion object {
        val empty = GoodEntity(0, 0, "", true, "", 0, 0)
    }

    fun toGoodData(): GoodData {

        // 가격
        val price = if (price == actual_price) price
        else actual_price

        // 세일율 구하기
        val salePercent = if (price == actual_price) 0
        else (price - actual_price) / price

        return GoodData(id, name, image, is_new, price.toString(), sell_count.toString(), salePercent.toString())
    }

}
