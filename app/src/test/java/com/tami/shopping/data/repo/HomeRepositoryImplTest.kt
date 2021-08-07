package com.tami.shopping.data.repo

import com.tami.shopping.data.FakeData
import com.tami.shopping.data.source.FakeFavoriteDataSource
import com.tami.shopping.data.source.FakeHomeDataSource
import com.tami.shopping.model.GoodData
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Test

class HomeRepositoryImplTest {


    private val homeDataSource = FakeHomeDataSource()
    private val favoriteDataSource = FakeFavoriteDataSource(FakeData.fakeFavoriteList)
    lateinit var homeRepository: HomeRepository

    @Before
    fun init() {
        homeRepository = HomeRepositoryImpl(homeDataSource, favoriteDataSource)
    }

    @Test
    fun getHomeDataList_IsFavoriteDataCheck() = runBlocking {

        val favoriteList = favoriteDataSource.favoriteGoodEntityList

        val homeData = homeRepository.getHomeDataList()
        val filterGoodDataList = homeData.filterIsInstance<GoodData>()
            .filter { it.isFavorite }


        assertThat(filterGoodDataList.size, `is`(favoriteList.size))
    }

}