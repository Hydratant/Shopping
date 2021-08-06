package com.tami.shopping.data.local

import android.os.Build
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.tami.shopping.entity.FavoriteGoodEntity
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.notNullValue
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O])
@RunWith(RobolectricTestRunner::class)
class FavoriteDaoTest {
    private lateinit var favoriteDao: FavoriteDao
    private lateinit var favoritesDatabase: FavoritesDatabase


    @Before
    fun init() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        favoritesDatabase = Room
            .inMemoryDatabaseBuilder(context, FavoritesDatabase::class.java)
            .build()

        favoriteDao = favoritesDatabase.favoritesDao()
    }

    @Test
    fun insertFavoriteAndGetById() = runBlocking {
        val favoriteGoodEntity = FavoriteGoodEntity(0, 3000, "image", true, "name", 3000, 10)
        favoriteDao.insertFavorite(favoriteGoodEntity)

        val loadEntity = favoriteDao.getFavoriteById(favoriteGoodEntity.id)

        assertThat(loadEntity as FavoriteGoodEntity, notNullValue())
        assertThat(loadEntity.id, `is`(favoriteGoodEntity.id))
        assertThat(loadEntity.actualPrice, `is`(favoriteGoodEntity.actualPrice))
        assertThat(loadEntity.image, `is`(favoriteGoodEntity.image))
        assertThat(loadEntity.isNew, `is`(favoriteGoodEntity.isNew))
        assertThat(loadEntity.name, `is`(favoriteGoodEntity.name))
        assertThat(loadEntity.price, `is`(favoriteGoodEntity.price))
        assertThat(loadEntity.sellCount, `is`(favoriteGoodEntity.sellCount))
    }

    @Test
    fun insertFavoriteReplacesOnConflict() = runBlocking {

        val favoriteGoodEntity = FavoriteGoodEntity(0, 3000, "image", true, "name", 3000, 10)
        favoriteDao.insertFavorite(favoriteGoodEntity)

        val favoriteGoodEntity2 = FavoriteGoodEntity(0, 4000, "image2", true, "name2", 4000, 20)
        favoriteDao.insertFavorite(favoriteGoodEntity2)

        val loadEntity = favoriteDao.getFavoriteById(favoriteGoodEntity.id)

        assertThat(loadEntity as FavoriteGoodEntity, notNullValue())
        assertThat(loadEntity.id, `is`(favoriteGoodEntity2.id))
        assertThat(loadEntity.actualPrice, `is`(favoriteGoodEntity2.actualPrice))
        assertThat(loadEntity.image, `is`(favoriteGoodEntity2.image))
        assertThat(loadEntity.isNew, `is`(favoriteGoodEntity2.isNew))
        assertThat(loadEntity.name, `is`(favoriteGoodEntity2.name))
        assertThat(loadEntity.price, `is`(favoriteGoodEntity2.price))
        assertThat(loadEntity.sellCount, `is`(favoriteGoodEntity2.sellCount))
    }

    @Test
    fun insertFavoriteGetFavoriteList() = runBlocking {
        val favoriteGoodEntity = FavoriteGoodEntity(0, 3000, "image", true, "name", 3000, 10)
        favoriteDao.insertFavorite(favoriteGoodEntity)

        val favoriteList = favoriteDao.getFavoriteList()

        assertThat(favoriteList.size, `is`(1))
        assertThat(favoriteList[0].id, `is`(favoriteGoodEntity.id))
        assertThat(favoriteList[0].actualPrice, `is`(favoriteGoodEntity.actualPrice))
        assertThat(favoriteList[0].image, `is`(favoriteGoodEntity.image))
        assertThat(favoriteList[0].isNew, `is`(favoriteGoodEntity.isNew))
        assertThat(favoriteList[0].name, `is`(favoriteGoodEntity.name))
        assertThat(favoriteList[0].price, `is`(favoriteGoodEntity.price))
        assertThat(favoriteList[0].sellCount, `is`(favoriteGoodEntity.sellCount))
    }

    @Test
    fun deleteFavoriteByIdAndGetFavoriteList() = runBlocking {
        val favoriteGoodEntity = FavoriteGoodEntity(0, 3000, "image", true, "name", 3000, 10)
        favoriteDao.insertFavorite(favoriteGoodEntity)

        favoriteDao.deleteFavoriteById(favoriteGoodEntity.id)

        val favoriteList = favoriteDao.getFavoriteList()
        assertThat(favoriteList.isEmpty(), `is`(true))
    }


    @After
    fun closeDb() = favoritesDatabase.close()
}