package com.tami.shopping.di

import android.content.Context
import androidx.room.Room
import com.tami.shopping.data.local.FavoriteDao
import com.tami.shopping.data.local.FavoritesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideFavoritesDatabase(@ApplicationContext context: Context): FavoritesDatabase =
        Room.databaseBuilder(context, FavoritesDatabase::class.java, "FavoritesUser.db").build()

    @Provides
    @Singleton
    fun provideFavoriteDao(favoritesDatabase: FavoritesDatabase): FavoriteDao =
        favoritesDatabase.favoritesDao()
}