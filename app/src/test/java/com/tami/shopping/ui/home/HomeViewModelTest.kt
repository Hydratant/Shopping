package com.tami.shopping.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.tami.shopping.MainCoroutineRule
import com.tami.shopping.R
import com.tami.shopping.data.repo.*
import com.tami.shopping.domain.DeleteFavoriteByIdUseCase
import com.tami.shopping.domain.GetGoodDataListUseCase
import com.tami.shopping.domain.GetHomeDataListUseCase
import com.tami.shopping.domain.InsertFavoriteUseCase
import com.tami.shopping.getOrAwaitValue
import com.tami.shopping.model.GoodData
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    lateinit var homeViewModel: HomeViewModel

    private lateinit var homeRepository: HomeRepository
    private lateinit var favoriteRepository: FavoriteRepository

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        homeViewModel = getTestHomeViewModel(false)
    }

    private fun getTestHomeViewModel(isException: Boolean): HomeViewModel {
        if (isException) {
            homeRepository = FakeHomeExceptionRepository()
            favoriteRepository = FakeFavoriteExceptionRepository()
        } else {
            homeRepository = FakeHomeRepository()
            favoriteRepository = FakeFavoriteRepository()
        }

        return HomeViewModel(
            GetHomeDataListUseCase(homeRepository),
            GetGoodDataListUseCase(homeRepository),
            InsertFavoriteUseCase(favoriteRepository),
            DeleteFavoriteByIdUseCase(favoriteRepository)
        )
    }

    @Test
    fun initGetHomeData() = runBlockingTest {
        assertThat(
            homeViewModel.homeDataList.getOrAwaitValue(),
            `is`(homeRepository.getHomeDataList())
        )
    }

    @Test
    fun getHomeDataExceptionErrorMessage() = runBlockingTest {
        homeViewModel = getTestHomeViewModel(true)
        homeViewModel.getHome()
        assertThat(
            homeViewModel.showErrorMessage.getOrAwaitValue().getContentIfNotHandled(),
            `is`(R.string.common_error_message)
        )
    }

    @Test
    fun getGoodDataAddHomeData() = runBlockingTest {
        val size = homeViewModel.homeDataList.getOrAwaitValue().size
        val fakeGoodDataSize = homeRepository.getGoodDataListByLastId(0).size

        homeViewModel.getGoodDataList()

        assertThat(
            homeViewModel.homeDataList.getOrAwaitValue().size,
            `is`(size + fakeGoodDataSize)
        )
    }

    @Test
    fun getGoodDataExceptionErrorMessage() = runBlockingTest {
        homeViewModel = getTestHomeViewModel(true)
        homeViewModel.getGoodDataList()
        assertThat(
            homeViewModel.showErrorMessage.getOrAwaitValue().getContentIfNotHandled(),
            `is`(R.string.common_error_message)
        )
    }


    @Test
    fun insertToastMessageAndNotifyItemChanged() {
        val goodData =
            GoodData(0, 0, "", true, "", 0, 0, false)

        homeViewModel.onFavoriteClick.invoke(goodData, 0)

        assertThat(
            homeViewModel.showToastMessage.getOrAwaitValue().getContentIfNotHandled(),
            `is`(R.string.favorite_insert_success)
        )

        assertThat(
            homeViewModel.notifyItemChanged.getOrAwaitValue(),
            `is`(0)
        )
    }

    @Test
    fun insertExceptionErrorMessage() = runBlockingTest {
        homeViewModel = getTestHomeViewModel(true)
        val goodData =
            GoodData(0, 0, "", true, "", 0, 0, false)

        homeViewModel.onFavoriteClick.invoke(goodData, 0)
        assertThat(
            homeViewModel.showErrorMessage.getOrAwaitValue().getContentIfNotHandled(),
            `is`(R.string.common_error_message)
        )
    }

    @Test
    fun deleteToastMessageAndNotifyItemChanged() {
        val goodData =
            GoodData(0, 0, "", true, "", 0, 0, true)

        homeViewModel.onFavoriteClick.invoke(goodData, 0)

        assertThat(
            homeViewModel.showToastMessage.getOrAwaitValue().getContentIfNotHandled(),
            `is`(R.string.favorite_delete_success)
        )

        assertThat(
            homeViewModel.notifyItemChanged.getOrAwaitValue(),
            `is`(0)
        )
    }

    @Test
    fun deleteExceptionErrorMessage() = runBlockingTest {
        homeViewModel = getTestHomeViewModel(true)
        val goodData =
            GoodData(0, 0, "", true, "", 0, 0, true)

        homeViewModel.onFavoriteClick.invoke(goodData, 0)
        assertThat(
            homeViewModel.showErrorMessage.getOrAwaitValue().getContentIfNotHandled(),
            `is`(R.string.common_error_message)
        )
    }

}