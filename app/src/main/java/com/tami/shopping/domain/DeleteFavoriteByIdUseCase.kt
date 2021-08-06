package com.tami.shopping.domain

import com.tami.shopping.data.repo.FavoriteRepository
import javax.inject.Inject

class DeleteFavoriteByIdUseCase @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) : BaseUseCase() {

    suspend operator fun invoke(id: Int): Result<Int> =
        run { favoriteRepository.deleteFavoriteById(id) }

}