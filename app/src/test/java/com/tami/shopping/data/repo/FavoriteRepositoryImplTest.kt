package com.tami.shopping.data.repo

import com.nhaarman.mockitokotlin2.mock
import com.tami.shopping.data.source.FavoriteDataSource
import com.tami.shopping.entity.FavoriteGoodEntity
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito


class FavoriteRepositoryImplTest {

    private val favoriteDataSource: FavoriteDataSource = mock()
    private lateinit var favoriteRepository: FavoriteRepository

    @Before
    fun init() {
        favoriteRepository = FavoriteRepositoryImpl(favoriteDataSource)
    }

    @Test
    fun getFavoriteListEntityToGoodData() = runBlocking {
        // Given
        val favoriteGoodEntity = FavoriteGoodEntity(0, 3000, "image", true, "name", 3000, 10)
        val goodData = favoriteGoodEntity.toGoodData()

        Mockito.`when`(favoriteDataSource.getFavoriteList())
            .thenReturn(listOf(favoriteGoodEntity))

        val favoriteList = favoriteRepository.getFavoriteList()

        assertThat(favoriteList[0].id, `is`(goodData.id))
        assertThat(favoriteList[0].actualPrice, `is`(goodData.actualPrice))
        assertThat(favoriteList[0].image, `is`(goodData.image))
        assertThat(favoriteList[0].isNew, `is`(goodData.isNew))
        assertThat(favoriteList[0].name, `is`(goodData.name))
        assertThat(favoriteList[0].price, `is`(goodData.price))
        assertThat(favoriteList[0].sellCount, `is`(goodData.sellCount))
        assertThat(favoriteList[0].isFavorite, `is`(goodData.isFavorite))
    }

    fun insertFavoriteGoodDataToFavoriteEntity() = runBlocking {

    }
}