package com.tami.shopping.ui.favorite

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tami.shopping.model.GoodData

object FavoriteBindingAdapter {

    @JvmStatic
    @BindingAdapter("app:favoriteList")
    fun setFavoriteList(
        recyclerView: RecyclerView,
        favoriteList: List<GoodData>?
    ) {
        ((recyclerView.adapter as? FavoriteAdapter))?.submitList(favoriteList)
            ?: run {
                recyclerView.adapter = FavoriteAdapter().apply { submitList(favoriteList) }
            }
    }
}