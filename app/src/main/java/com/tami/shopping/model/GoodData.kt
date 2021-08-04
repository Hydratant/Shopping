package com.tami.shopping.model


data class GoodData(
    val id: Int,            // Id
    val actualPrice: Int,   // 실제 가격
    val image: String,      // Image Url
    val isNew: Boolean,     // 신상 여부
    val name: String,       // 이름
    val price: Int,         // 판매 가격
    val sellCount: Int      // 판매수
) {
    companion object {
        val empty = GoodData(0, 0, "", true, "", 0, 0)
    }

    val salePercent: String
        get() {
            val percent = if (actualPrice == price) 0
            else ((actualPrice - price) / actualPrice)
            return percent.toString()
        }


    val showPrice: String
        get() {
            val showPrice = if (actualPrice == price) actualPrice
            else price
            return showPrice.toString()
        }
}