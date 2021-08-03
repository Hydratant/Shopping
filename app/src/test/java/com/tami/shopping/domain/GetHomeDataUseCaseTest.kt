package com.tami.shopping.domain

import com.nhaarman.mockitokotlin2.mock
import com.tami.shopping.data.repo.HomeRepository
import org.junit.Before

class GetHomeDataUseCaseTest {

    private val homeRepository: HomeRepository = mock()
    lateinit var getHomeDataUseCase: GetHomeDataUseCase

    @Before
    fun init() {
        getHomeDataUseCase = GetHomeDataUseCase(homeRepository)
    }


}