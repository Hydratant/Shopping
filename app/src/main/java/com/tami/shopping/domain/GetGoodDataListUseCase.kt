package com.tami.shopping.domain

import com.tami.shopping.data.repo.HomeRepository
import com.tami.shopping.model.GoodData
import javax.inject.Inject

class GetGoodDataListUseCase @Inject constructor(
    private val homeRepository: HomeRepository
) : BaseUseCase() {

    suspend operator fun invoke(lastId: Int): Result<List<GoodData>> =
        run { homeRepository.getGoodDataList(lastId) }
}