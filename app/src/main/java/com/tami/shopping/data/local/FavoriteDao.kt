package com.tami.shopping.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tami.shopping.entity.FavoriteGoodEntity

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorites")
    fun getFavoriteList(): List<FavoriteGoodEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favoriteGoodEntity: FavoriteGoodEntity)

    @Query("DELETE FROM favorites WHERE id = :id")
    suspend fun deleteTaskById(id: Int): Int
}