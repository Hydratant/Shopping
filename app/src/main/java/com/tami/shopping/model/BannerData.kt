package com.tami.shopping.model


data class BannerData(
    val id: Int,            // ID
    val image: String       // Banner ImageUrl
) {
    companion object {
        val empty = BannerData(0, "")
    }
}