package com.tami.shopping.data.local

import com.tami.shopping.entity.HomeEntity

interface HomeCache {
    fun put(homeEntity: HomeEntity)
    fun get(): HomeEntity?
    fun clear()
}