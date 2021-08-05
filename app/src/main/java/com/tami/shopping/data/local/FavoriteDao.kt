package com.tami.shopping.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tami.shopping.entity.FavoriteGoodEntity

@Dao
interface FavoriteDao {

    @Query("SELECT * FROM favorites")
    suspend fun getFavoriteList(): List<FavoriteGoodEntity>

    @Query("SELECT * FROM favorites")
    fun getObserveFavoriteList(): LiveData<List<FavoriteGoodEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(favoriteGoodEntity: FavoriteGoodEntity)

    @Query("DELETE FROM favorites WHERE id = :id")
    suspend fun deleteTaskById(id: Int): Int
}