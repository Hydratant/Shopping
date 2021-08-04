package com.tami.shopping.data.local

import com.tami.shopping.entity.HomeEntity

class HomeCacheImpl : HomeCache {
    private var homeEntity: HomeEntity? = null
    override fun put(homeEntity: HomeEntity) {
        this.homeEntity = homeEntity
    }

    override fun get(): HomeEntity? = homeEntity
    override fun clear() {
        homeEntity = null
    }
}