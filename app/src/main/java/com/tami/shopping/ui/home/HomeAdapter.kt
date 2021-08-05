package com.tami.shopping.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tami.shopping.R
import com.tami.shopping.databinding.GoodItemBinding
import com.tami.shopping.databinding.HomeBannerItemBinding
import com.tami.shopping.model.GoodData
import com.tami.shopping.model.HomeBannerData
import com.tami.shopping.model.HomeData

class HomeAdapter : ListAdapter<HomeData, RecyclerView.ViewHolder>(DIFF_CALLBACK) {

    var onFavoriteClick: ((GoodData) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        return when (viewType) {
            BANNER_TYPE -> {
                val bb: HomeBannerItemBinding =
                    DataBindingUtil.inflate(inflater, R.layout.home_banner_item, parent, false)
                HomeBannerViewHolder(bb)
            }
            GOOD_TYPE -> {
                val bb: GoodItemBinding =
                    DataBindingUtil.inflate(inflater, R.layout.good_item, parent, false)
                GoodViewHolder(bb, onFavoriteClick)
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        when (holder) {
            is GoodViewHolder -> holder.bind(item as GoodData)
            is HomeBannerViewHolder -> holder.bind(item as HomeBannerData)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is HomeBannerData -> BANNER_TYPE
            is GoodData -> GOOD_TYPE
            else -> throw IllegalArgumentException()
        }
    }

    companion object {
        const val BANNER_TYPE = 0
        const val GOOD_TYPE = 1

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<HomeData>() {
            override fun areItemsTheSame(oldItem: HomeData, newItem: HomeData): Boolean {
                return if (oldItem is GoodData && newItem is GoodData) {
                    oldItem.id == newItem.id
                } else
                    oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: HomeData, newItem: HomeData): Boolean =
                oldItem == newItem
        }
    }
}

class GoodViewHolder(
    private val bb: GoodItemBinding,
    private val onFavoriteClick: ((GoodData) -> Unit)? = null
) : RecyclerView.ViewHolder(bb.root) {
    fun bind(item: GoodData) {
        with(bb) {
            this.item = item
            favorite.setOnClickListener { onFavoriteClick?.invoke(item) }
        }
    }
}

class HomeBannerViewHolder(private val bb: HomeBannerItemBinding) :
    RecyclerView.ViewHolder(bb.root) {
    fun bind(item: HomeBannerData) {
        with(bb) { this.item = item }
    }
}
