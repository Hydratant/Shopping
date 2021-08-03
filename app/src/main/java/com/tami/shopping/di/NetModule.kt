package com.tami.shopping.di

import com.tami.shopping.ShoppingApplication
import com.tami.shopping.data.remote.ShoppingApi
import com.tami.shopping.net.NetConst
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient().newBuilder().run {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = if (ShoppingApplication.IS_DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
            })
            build()
        }
    }


    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().run {
            baseUrl(NetConst.BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
            client(okHttpClient)
            build()
        }
    }

    @Singleton
    @Provides
    fun provideShoppingApi(retrofit: Retrofit): ShoppingApi =
        retrofit.create(ShoppingApi::class.java)
}