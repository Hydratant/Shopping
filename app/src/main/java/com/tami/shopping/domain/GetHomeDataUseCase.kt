package com.tami.shopping.domain

import com.tami.shopping.data.repo.HomeRepository
import com.tami.shopping.model.HomeData
import javax.inject.Inject

class GetHomeDataUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) : BaseUseCase() {

    suspend operator fun invoke(): Result<HomeData> =
        run { homeRepository.getHomeData() }
}