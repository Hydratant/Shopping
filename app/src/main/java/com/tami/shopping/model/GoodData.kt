package com.tami.shopping.model


data class GoodData(
    val id: Int,                // Id
    val name: String,           // 이름
    val image: String,          // Image Url
    val isNew: Boolean,         // 신상 여부
    val price: String,          // 가격
    val sellCount: String,      // 구매수
    val salePercent: String,    // 세일 Percent
) {
    companion object {
        val empty = GoodData(0, "", "", true, "", "", "")
    }
}