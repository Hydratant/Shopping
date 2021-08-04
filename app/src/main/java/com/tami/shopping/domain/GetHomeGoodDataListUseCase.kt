package com.tami.shopping.domain

import com.tami.shopping.data.repo.GoodRepository
import com.tami.shopping.model.GoodData
import javax.inject.Inject

class GetHomeGoodDataListUseCase @Inject constructor(
    private val goodRepository: GoodRepository
) : BaseUseCase() {
    suspend operator fun invoke(): Result<List<GoodData>> =
        run { goodRepository.getHomeGoodDataList() }
}