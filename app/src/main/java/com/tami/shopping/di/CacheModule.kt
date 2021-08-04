package com.tami.shopping.di

import com.tami.shopping.data.local.HomeCache
import com.tami.shopping.data.local.HomeCacheImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideHomeCache(): HomeCache = HomeCacheImpl()
}