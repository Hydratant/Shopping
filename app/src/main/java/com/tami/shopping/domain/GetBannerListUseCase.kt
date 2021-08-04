package com.tami.shopping.domain

import com.tami.shopping.data.repo.BannerRepository
import com.tami.shopping.model.BannerData
import timber.log.Timber
import javax.inject.Inject

class GetBannerListUseCase @Inject constructor(
    private val bannerRepository: BannerRepository
) : BaseUseCase() {
    suspend operator fun invoke(): Result<List<BannerData>> =
        run {
            Timber.i("GetBannerListUseCase")
            bannerRepository.getBannerDataList()
        }
}