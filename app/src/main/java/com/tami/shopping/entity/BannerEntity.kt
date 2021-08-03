package com.tami.shopping.entity

import com.tami.shopping.model.BannerData

data class BannerEntity(
    val id: Int,            // ID
    val image: String       // Banner ImageUrl
) {
    companion object {
        val empty = BannerEntity(0, "")
    }

    fun toBannerData(): BannerData = BannerData(id, image)
}