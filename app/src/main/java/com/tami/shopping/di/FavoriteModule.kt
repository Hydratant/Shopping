package com.tami.shopping.di

import com.tami.shopping.data.local.FavoriteDao
import com.tami.shopping.data.repo.FavoriteRepository
import com.tami.shopping.data.repo.FavoriteRepositoryImpl
import com.tami.shopping.data.source.FavoriteDataSource
import com.tami.shopping.data.source.FavoriteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoriteModule {

    @Singleton
    @Provides
    fun provideFavoriteDataSource(
        favoriteDao: FavoriteDao,
        ioDispatcher: CoroutineDispatcher
    ): FavoriteDataSource =
        FavoriteDataSourceImpl(favoriteDao, ioDispatcher)

    @Singleton
    @Provides
    fun provideFavoriteRepository(favoriteDataSource: FavoriteDataSource): FavoriteRepository =
        FavoriteRepositoryImpl(favoriteDataSource)

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}