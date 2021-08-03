package com.tami.shopping.utils

import android.widget.ImageView
import androidx.annotation.DimenRes
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

object BindingAdapter {

    /**
     * url을 통해 ProfileImage를 불러온다.
     */
    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun setImageWithUrl(imageView: ImageView, url: String?) {
        val context = imageView.context
        Glide.with(context)
            .load(url)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView)
    }

    /**
     * SwipeRefresh Refresh
     */
    @JvmStatic
    @BindingAdapter("app:onRefresh")
    fun setSwipeRefreshLayoutRefresh(
        swipeRefreshLayout: SwipeRefreshLayout,
        onRefresh: (() -> Unit)?
    ) {
        swipeRefreshLayout.setOnRefreshListener {
            onRefresh?.invoke()
            swipeRefreshLayout.isRefreshing = false
        }
    }

    /**
     * RecyclerView Scroll Last
     */
    @JvmStatic
    @BindingAdapter("app:onScrollLast")
    fun setOnLastScroll(
        recyclerView: RecyclerView,
        onScrollLast: (() -> Unit)?
    ) {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val isLast =
                    !recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE
                if (isLast) {
                    onScrollLast?.invoke()
                }
            }
        })
    }

    @JvmStatic
    @BindingAdapter("app:halfPageMargin", "app:peekOffSet", requireAll = true)
    fun setViewPager2PageMargin(
        viewPager2: ViewPager2,
        @DimenRes halfPageMargin: Int,
        @DimenRes peekOffSet: Int,
    ) {
        viewPager2.offscreenPageLimit = 1
        val recyclerView = viewPager2.getChildAt(0) as RecyclerView
        recyclerView.apply {
            val padding = resources.getDimensionPixelOffset(halfPageMargin) +
                    resources.getDimensionPixelOffset(peekOffSet)
            setPadding(padding, 0, padding, 0)
            clipToPadding = false
        }
    }
}