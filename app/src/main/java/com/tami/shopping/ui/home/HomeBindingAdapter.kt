package com.tami.shopping.ui.home

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.tami.shopping.R
import com.tami.shopping.model.BannerData
import com.tami.shopping.model.GoodData
import com.tami.shopping.model.HomeData


object HomeBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:bannerList")
    fun setBannerList(
        viewPager2: ViewPager2,
        bannerList: List<BannerData>
    ) {
        ((viewPager2.adapter as? BannerAdapter)?.submitList(bannerList))
            ?: run { viewPager2.adapter = BannerAdapter().apply { submitList(bannerList) } }
    }

    @JvmStatic
    @BindingAdapter(
        "app:homeList",
        "app:onFavoriteClick",
        requireAll = false
    )
    fun setHomeList(
        recyclerView: RecyclerView,
        homeDataList: List<HomeData>,
        onFavoriteClick: ((GoodData, Int) -> Unit)?
    ) {
        ((recyclerView.adapter as? HomeAdapter))?.set(homeDataList)
            ?: run {
                recyclerView.adapter = HomeAdapter().apply {
                    set(homeDataList)
                    setHasStableIds(true)
                    this.onFavoriteClick = onFavoriteClick
                }
                recyclerView.itemAnimator = null
            }
    }


    @JvmStatic
    @BindingAdapter("app:spanSizeLookup")
    fun setSpanSizeLookup(
        recyclerView: RecyclerView,
        spanSizeLookup: GridLayoutManager.SpanSizeLookup
    ) {
        (recyclerView.layoutManager as? GridLayoutManager)?.spanSizeLookup = spanSizeLookup
    }

    @JvmStatic
    @BindingAdapter(
        "app:currentPage",
        "app:totalPage",
        requireAll = true
    )
    fun setBannerPage(
        textView: TextView,
        currentPage: Int,
        totalPage: Int
    ) {
        textView.text =
            String.format(textView.context.getString(R.string.banner_page), currentPage, totalPage)
    }
}