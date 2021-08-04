package com.tami.shopping.di

import com.tami.shopping.data.remote.ShoppingApi
import com.tami.shopping.data.repo.HomeRepository
import com.tami.shopping.data.repo.HomeRepositoryImpl
import com.tami.shopping.data.source.FavoriteDataSource
import com.tami.shopping.data.source.HomeDataSource
import com.tami.shopping.data.source.HomeDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object HomeModule {

    @Provides
    fun provideHomeDataSource(shoppingApi: ShoppingApi): HomeDataSource =
        HomeDataSourceImpl(shoppingApi)

    @Provides
    fun provideHomeRepository(
        homeDatasource: HomeDataSource,
        favoriteDataSource: FavoriteDataSource
    ): HomeRepository =
        HomeRepositoryImpl(homeDatasource, favoriteDataSource)
}