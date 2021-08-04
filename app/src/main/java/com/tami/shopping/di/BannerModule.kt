package com.tami.shopping.di

import com.tami.shopping.data.local.HomeCache
import com.tami.shopping.data.remote.ShoppingApi
import com.tami.shopping.data.repo.BannerRepository
import com.tami.shopping.data.repo.BannerRepositoryImpl
import com.tami.shopping.data.source.BannerDataSource
import com.tami.shopping.data.source.BannerDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object BannerModule {

    @Provides
    fun provideBannerDataSource(
        shoppingApi: ShoppingApi,
        homeCache: HomeCache
    ): BannerDataSource = BannerDataSourceImpl(shoppingApi, homeCache)

    @Provides
    fun provideBannerRepository(bannerDataSource: BannerDataSource): BannerRepository =
        BannerRepositoryImpl(bannerDataSource)
}