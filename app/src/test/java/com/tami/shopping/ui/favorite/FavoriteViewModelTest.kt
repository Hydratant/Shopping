package com.tami.shopping.ui.favorite

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tami.shopping.data.FakeData
import com.tami.shopping.data.repo.FakeFavoriteExceptionRepository
import com.tami.shopping.data.repo.FakeFavoriteRepository
import com.tami.shopping.data.repo.FavoriteRepository
import com.tami.shopping.domain.ObserveGetFavoriteListUseCase
import com.tami.shopping.getOrAwaitValue
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FavoriteViewModelTest {

    lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var favoriteRepository: FavoriteRepository

    private val fakeFavoriteList = FakeData.fakeFavoriteList.map { it.toGoodData() }

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        favoriteViewModel = getTestFavoriteViewModel(false)
    }

    private fun getTestFavoriteViewModel(isException: Boolean): FavoriteViewModel {
        favoriteRepository = if (isException) {
            FakeFavoriteExceptionRepository()
        } else {
            FakeFavoriteRepository(fakeFavoriteList)
        }
        return FavoriteViewModel(
            ObserveGetFavoriteListUseCase(favoriteRepository)
        )
    }

    @Test
    fun initGetFavorite() {
        assertThat(
            favoriteViewModel.favoriteList.getOrAwaitValue(),
            `is`(fakeFavoriteList)
        )
    }

    @Test
    fun getFavoriteListNotEmptyIsShowFavoriteList() {
        assertThat(
            favoriteViewModel.isShowFavoriteList.getOrAwaitValue(),
            `is`(true)
        )
    }

    @Test
    fun getFavoriteListEmptyIsShowEmptyTextTrue() {
        favoriteRepository = FakeFavoriteRepository(emptyList())
        favoriteViewModel = FavoriteViewModel(ObserveGetFavoriteListUseCase(favoriteRepository))
        assertThat(
            favoriteViewModel.isShowEmptyText.getOrAwaitValue(),
            `is`(true)
        )
    }
}