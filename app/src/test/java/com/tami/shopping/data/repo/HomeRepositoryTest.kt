package com.tami.shopping.data.repo

import com.nhaarman.mockitokotlin2.mock
import com.tami.shopping.data.source.HomeDataSource
import com.tami.shopping.entity.HomeEntity
import com.tami.shopping.model.HomeData
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito


class HomeRepositoryTest {

    private val emptyHomeEntity = HomeEntity.empty

    private val homeDataSource: HomeDataSource = mock()
    lateinit var homeRepository: HomeRepository


    @Before
    fun init() {
        homeRepository = HomeRepositoryImpl(homeDataSource)
    }


    @Test
    fun successResponse_HomeEntityToHomeData_Test(): Unit = runBlocking {
        Mockito.`when`(homeDataSource.getHome())
            .thenReturn(emptyHomeEntity)

        val homeData = homeRepository.getHomeData()

        MatcherAssert.assertThat(homeData, Matchers.`is`(HomeData.empty))
    }
}