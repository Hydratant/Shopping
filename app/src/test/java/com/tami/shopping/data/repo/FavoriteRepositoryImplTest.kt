package com.tami.shopping.data.repo

import com.tami.shopping.data.source.FakeFavoriteDataSource
import com.tami.shopping.data.source.FavoriteDataSource
import com.tami.shopping.entity.FavoriteGoodEntity
import com.tami.shopping.model.GoodData
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Test


class FavoriteRepositoryImplTest {

    private val favoriteDataSource: FavoriteDataSource = FakeFavoriteDataSource()
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

        favoriteRepository.insertFavorite(goodData)

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

    @Test
    fun insertFavoriteGoodDataToFavoriteEntity() = runBlocking {
        val goodData = GoodData(0, 3000, "image", true, "name", 3000, 10, true)
        val favoriteGoodEntity = goodData.toFavoriteGoodEntity()

        favoriteRepository.insertFavorite(goodData)

        val favoriteList = favoriteRepository.getFavoriteList()

        assertThat(favoriteList[0].id, `is`(favoriteGoodEntity.id))
        assertThat(favoriteList[0].actualPrice, `is`(favoriteGoodEntity.actualPrice))
        assertThat(favoriteList[0].image, `is`(favoriteGoodEntity.image))
        assertThat(favoriteList[0].isNew, `is`(favoriteGoodEntity.isNew))
        assertThat(favoriteList[0].name, `is`(favoriteGoodEntity.name))
        assertThat(favoriteList[0].price, `is`(favoriteGoodEntity.price))
        assertThat(favoriteList[0].sellCount, `is`(favoriteGoodEntity.sellCount))
    }

    @Test
    fun deleteFavoriteById() = runBlocking {
        val goodData = GoodData(0, 3000, "image", true, "name", 3000, 10, true)
        favoriteRepository.insertFavorite(goodData)

        favoriteRepository.deleteFavoriteById(goodData.id)

        val favoriteList = favoriteRepository.getFavoriteList()
        assertThat(favoriteList.isEmpty(), `is`(true))
    }
}