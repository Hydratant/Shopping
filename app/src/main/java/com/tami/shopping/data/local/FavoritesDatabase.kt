package com.tami.shopping.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tami.shopping.entity.FavoriteGoodEntity

@Database(entities = [FavoriteGoodEntity::class], version = 1, exportSchema = true)
abstract class FavoritesDatabase : RoomDatabase() {
    abstract fun favoritesDao(): FavoriteDao
}