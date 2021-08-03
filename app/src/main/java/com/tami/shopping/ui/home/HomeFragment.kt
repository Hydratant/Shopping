package com.tami.shopping.ui.home

import androidx.fragment.app.viewModels
import com.tami.shopping.R
import com.tami.shopping.base.ui.BindingFragment
import com.tami.shopping.databinding.HomeFrBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BindingFragment<HomeFrBinding>(R.layout.home_fr) {

    private val vm: HomeViewModel by viewModels()
    override fun onLoadOnce() {
        vm.bannerDataList.observe(viewLifecycleOwner) {
            it?.let { list ->
                bb.banner.adapter = BannerAdapter().apply {
                    set(list)
                }
            }
        }

        vm.goodDataList.observe(viewLifecycleOwner) {
            it?.let { list ->
                bb.good.adapter = GoodAdapter().apply {
                    set(list)
                }
            }
        }
    }
}