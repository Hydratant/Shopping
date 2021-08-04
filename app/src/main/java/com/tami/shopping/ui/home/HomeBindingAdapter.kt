package com.tami.shopping.ui.home

import androidx.databinding.BindingAdapter
import androidx.viewpager2.widget.ViewPager2
import com.tami.shopping.model.BannerData


object HomeBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:bannerList")
    fun setBannerList(viewPager2: ViewPager2, bannerList: List<BannerData>) {
        ((viewPager2.adapter as? BannerAdapter)?.submitList(bannerList))
            ?: run { viewPager2.adapter = BannerAdapter().apply { submitList(bannerList) } }
    }
}