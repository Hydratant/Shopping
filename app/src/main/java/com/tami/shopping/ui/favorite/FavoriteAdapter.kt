package com.tami.shopping.ui.favorite

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import com.tami.shopping.R
import com.tami.shopping.base.recycler.BindingViewHolder
import com.tami.shopping.base.recycler.ListBindingAdapter
import com.tami.shopping.databinding.FavoriteGoodItemBinding
import com.tami.shopping.model.GoodData

class FavoriteAdapter : ListBindingAdapter<GoodData, FavoriteGoodItemBinding, FavoriteViewHolder>(
    DIFF_CALLBACK,
    R.layout.favorite_good_item,
    FavoriteViewHolder::class.java
) {
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GoodData>() {
            override fun areItemsTheSame(oldItem: GoodData, newItem: GoodData): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: GoodData, newItem: GoodData): Boolean =
                oldItem == newItem
        }
    }
}

class FavoriteViewHolder(itemView: View) :
    BindingViewHolder<GoodData, FavoriteGoodItemBinding>(itemView) {
    override fun bind(item: GoodData) {
        with(bb) {
            this.item = item
            executePendingBindings()
        }
    }

}