package com.tami.shopping.ui.home

import android.view.View
import com.tami.shopping.R
import com.tami.shopping.base.recycler.BindingViewHolder
import com.tami.shopping.base.recycler.SingleBindingAdapter
import com.tami.shopping.databinding.GoodItemBinding
import com.tami.shopping.model.GoodData

class GoodAdapter : SingleBindingAdapter<GoodData, GoodItemBinding, GoodViewHolder>(
    R.layout.good_item,
    GoodViewHolder::class.java
)

class GoodViewHolder(itemView: View) :
    BindingViewHolder<GoodData, GoodItemBinding>(itemView) {
    override fun bind(item: GoodData) {
        with(bb) { this.item = item }
    }
}