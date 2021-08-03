package com.tami.shopping.domain

import com.nhaarman.mockitokotlin2.mock
import com.tami.shopping.data.repo.HomeRepository
import com.tami.shopping.mockitoException
import com.tami.shopping.model.HomeData
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class GetHomeDataUseCaseTest {

    private val homeRepository: HomeRepository = mock()
    lateinit var getHomeDataUseCase: GetHomeDataUseCase

    private val emptyHomeData = HomeData.empty


    @Before
    fun init() {
        getHomeDataUseCase = GetHomeDataUseCase(homeRepository)
    }

    @Test
    fun successResponse_Result_HomeData() = runBlocking {
        Mockito.`when`(homeRepository.getHomeData())
            .thenReturn(emptyHomeData)

        val result = getHomeDataUseCase()

        MatcherAssert.assertThat(
            result,
            Matchers.`is`(Result.success(emptyHomeData))
        )
    }

    @Test
    fun failResponse_Result_Fail() = runBlocking {
        Mockito.`when`(homeRepository.getHomeData())
            .thenThrow(mockitoException)

        val result = getHomeDataUseCase()

        MatcherAssert.assertThat(
            result,
            Matchers.`is`(Result.failure(mockitoException))
        )
    }


}