package com.tami.shopping.di

import com.tami.shopping.data.local.HomeCache
import com.tami.shopping.data.remote.ShoppingApi
import com.tami.shopping.data.repo.GoodRepository
import com.tami.shopping.data.repo.GoodRepositoryImpl
import com.tami.shopping.data.source.GoodDataSource
import com.tami.shopping.data.source.GoodDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object GoodModule {

    @Provides
    fun provideGoodDataSource(
        shoppingApi: ShoppingApi,
        homeCache: HomeCache
    ): GoodDataSource = GoodDataSourceImpl(shoppingApi, homeCache)

    @Provides
    fun provideGoodRepository(goodDataSource: GoodDataSource): GoodRepository =
        GoodRepositoryImpl(goodDataSource)
}