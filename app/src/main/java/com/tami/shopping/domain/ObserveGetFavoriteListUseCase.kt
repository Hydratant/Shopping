package com.tami.shopping.domain

import androidx.lifecycle.LiveData
import com.tami.shopping.data.repo.FavoriteRepository
import com.tami.shopping.model.GoodData
import javax.inject.Inject

class ObserveGetFavoriteListUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) : BaseUseCase() {
    suspend operator fun invoke(): LiveData<Result<List<GoodData>>> =
        favoriteRepository.getObserveFavoriteList()
}
