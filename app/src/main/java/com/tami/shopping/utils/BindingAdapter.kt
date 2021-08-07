package com.tami.shopping.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
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
     * View Visible Gone
     */
    @JvmStatic
    @BindingAdapter("app:isVisible")
    fun setVisible(view: View, isVisible: Boolean) {
        if (isVisible)
            view.visibility = View.VISIBLE
        else view.visibility = View.GONE
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
}