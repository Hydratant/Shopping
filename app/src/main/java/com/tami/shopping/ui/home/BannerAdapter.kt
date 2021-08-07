package com.tami.shopping.ui.home

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.tami.shopping.R
import com.tami.shopping.base.recycler.BindingViewHolder
import com.tami.shopping.base.recycler.ListBindingAdapter
import com.tami.shopping.databinding.BannerItemBinding
import com.tami.shopping.model.BannerData

class BannerAdapter :
    ListBindingAdapter<BannerData, BannerItemBinding, BannerViewHolder>(
        DIFF_CALLBACK,
        R.layout.banner_item,
        BannerViewHolder::class.java
    ) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<BannerData>() {
            override fun areItemsTheSame(oldItem: BannerData, newItem: BannerData): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: BannerData, newItem: BannerData): Boolean =
                oldItem == newItem
        }
    }
}


class BannerViewHolder(itemView: View) :
    BindingViewHolder<BannerData, BannerItemBinding>(itemView) {
    override fun bind(item: BannerData) {
        with(bb) {
            this.item = item
            executePendingBindings()
        }
    }
}