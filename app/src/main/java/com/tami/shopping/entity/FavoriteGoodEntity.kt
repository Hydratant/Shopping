package com.tami.shopping.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tami.shopping.model.GoodData

@Entity(tableName = "favorites")
data class FavoriteGoodEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")            val id: Int = 0,        // Id
    @ColumnInfo(name = "actualPrice")   val actualPrice: Int,   // 실제 가격
    @ColumnInfo(name = "image")         val image: String,      // Image Url
    @ColumnInfo(name = "isNew")         val isNew: Boolean,     // 신상 여부
    @ColumnInfo(name = "name")          val name: String,       // 이름
    @ColumnInfo(name = "price")         val price: Int,         // 판매 가격
    @ColumnInfo(name = "sellCount")     val sellCount: Int,     // 판매수
) {
    fun toGoodData(): GoodData =
        GoodData(id, actualPrice, image, isNew, name, price, sellCount, true)
}