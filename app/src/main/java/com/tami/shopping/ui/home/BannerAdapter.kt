package com.tami.shopping.ui.home

import android.view.View
import com.tami.shopping.R
import com.tami.shopping.base.recycler.BindingViewHolder
import com.tami.shopping.base.recycler.SingleBindingAdapter
import com.tami.shopping.databinding.BannerItemBinding
import com.tami.shopping.model.BannerData

class BannerAdapter :
    SingleBindingAdapter<BannerData, BannerItemBinding, BannerViewHolder>(
        R.layout.banner_item,
        BannerViewHolder::class.java
    )

class BannerViewHolder(itemView: View) :
    BindingViewHolder<BannerData, BannerItemBinding>(itemView) {
    override fun bind(item: BannerData) {
        with(bb) { this.item = item }
    }
}