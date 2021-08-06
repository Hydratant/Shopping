package com.tami.shopping.data.source

import android.os.Build
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.tami.shopping.data.local.FavoriteDao
import com.tami.shopping.data.local.FavoritesDatabase
import com.tami.shopping.entity.FavoriteGoodEntity
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O])
@RunWith(RobolectricTestRunner::class)
class FavoriteDataSourceImplTest {

    private lateinit var favoriteDao: FavoriteDao
    private lateinit var favoritesDatabase: FavoritesDatabase

    private lateinit var favoriteDataSource: FavoriteDataSource

    @Before
    fun init() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        favoritesDatabase = Room
            .inMemoryDatabaseBuilder(context, FavoritesDatabase::class.java)
            .build()

        favoriteDao = favoritesDatabase.favoritesDao()

        favoriteDataSource = FavoriteDataSourceImpl(favoriteDao)
    }

    @Test
    fun insertFavoriteGetFavoriteList() = runBlocking {
        val favoriteGoodEntity = FavoriteGoodEntity(0, 3000, "image", true, "name", 3000, 10)
        favoriteDataSource.insertFavorite(favoriteGoodEntity)

        val favoriteList = favoriteDataSource.getFavoriteList()

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
        favoriteDataSource.insertFavorite(favoriteGoodEntity)

        favoriteDataSource.deleteFavoriteById(favoriteGoodEntity.id)

        val favoriteList = favoriteDataSource.getFavoriteList()
        assertThat(favoriteList.isEmpty(), `is`(true))
    }


    @After
    fun close() = favoritesDatabase.close()

}