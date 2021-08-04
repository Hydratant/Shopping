package com.tami.shopping.ui.home

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.tami.shopping.R
import com.tami.shopping.base.recycler.BindingViewHolder
import com.tami.shopping.base.recycler.ListBindingAdapter
import com.tami.shopping.databinding.GoodItemBinding
import com.tami.shopping.model.GoodData


class GoodAdapter : ListBindingAdapter<GoodData, GoodItemBinding, GoodViewHolder>
    (DIFF_CALLBACK, R.layout.good_item, GoodViewHolder::class.java) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GoodData>() {
            override fun areItemsTheSame(oldItem: GoodData, newItem: GoodData): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: GoodData, newItem: GoodData): Boolean =
                oldItem == newItem
        }
    }
}


class GoodViewHolder(itemView: View) : BindingViewHolder<GoodData, GoodItemBinding>(itemView) {
    override fun bind(item: GoodData) {
        with(bb) { this.item = item }
    }
}