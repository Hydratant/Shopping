package com.tami.shopping.model


data class GoodData(
    val id: Int,            // Id
    val actualPrice: Int,  // 세일 가격
    val image: String,      // Image Url
    val isNew: Boolean,    // 신상 여부
    val name: String,       // 이름
    val price: Int,         // 가격
    val sellCount: Int     // 판매수
) {
    companion object {
        val empty = GoodData(0, 0, "", true, "", 0, 0)
    }
}