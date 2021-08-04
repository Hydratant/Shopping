package com.tami.shopping.domain

import com.tami.shopping.data.repo.FavoriteRepository
import com.tami.shopping.model.GoodData
import javax.inject.Inject

class InsertFavoriteUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) : BaseUseCase() {

    suspend operator fun invoke(goodData: GoodData) = run {
        favoriteRepository.insertFavorite(goodData)
    }
}