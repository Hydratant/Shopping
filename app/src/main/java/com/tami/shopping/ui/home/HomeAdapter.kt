package com.tami.shopping.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.tami.shopping.R
import com.tami.shopping.databinding.GoodItemBinding
import com.tami.shopping.databinding.HomeBannerItemBinding
import com.tami.shopping.model.GoodData
import com.tami.shopping.model.HomeBannerData
import com.tami.shopping.model.HomeData

class HomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val items = mutableListOf<HomeData>()
    var onFavoriteClick: ((GoodData, Int) -> Unit)? = null
    var onViewPagerRefresh: (() -> Unit)? = null

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
            is HomeBannerViewHolder -> {
                holder.bind(item as HomeBannerData)
                onViewPagerRefresh = { holder.currentItemInit() }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is HomeBannerData -> BANNER_TYPE
            is GoodData -> GOOD_TYPE
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemId(position: Int): Long {
        val item = getItem(position)
        return when (item) {
            is HomeBannerData -> hashCode().toLong()
            is GoodData -> item.id.toLong()
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int = items.size
    fun getItem(position: Int): HomeData = items[position]
    fun set(items: List<HomeData>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    companion object {
        const val BANNER_TYPE = 0
        const val GOOD_TYPE = 1
    }

}

class GoodViewHolder(
    private val bb: GoodItemBinding,
    private val onFavoriteClick: ((GoodData, Int) -> Unit)? = null
) : RecyclerView.ViewHolder(bb.root) {
    fun bind(item: GoodData) {
        with(bb) {
            this.item = item
            favorite.setOnClickListener {
                if (bindingAdapterPosition != RecyclerView.NO_POSITION)
                    onFavoriteClick?.invoke(item, bindingAdapterPosition)
            }
            executePendingBindings()
        }
    }
}

class HomeBannerViewHolder(private val bb: HomeBannerItemBinding) :
    RecyclerView.ViewHolder(bb.root) {
    fun bind(item: HomeBannerData) {
        with(bb) {
            this.item = item
            bb.banner.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    this@with.item = item.apply {
                        currentPage = position + 1
                    }
                }
            })
            executePendingBindings()
        }
    }

    fun currentItemInit() {
        bb.banner.currentItem = 0
    }
}
