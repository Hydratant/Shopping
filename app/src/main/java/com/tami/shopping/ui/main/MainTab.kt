package com.tami.shopping.ui.main

import com.tami.shopping.R
import com.tami.shopping.ui.favorite.FavoriteFragment
import com.tami.shopping.ui.home.HomeFragment

enum class MainTab(
    val itemId: Int,
    val tag: String
) {
    HOME(R.id.navigation_home, HomeFragment.TAG),
    FAVORITE(R.id.navigation_favorite, FavoriteFragment.TAG);

    companion object {
        fun otherTab(exceptTag: String): Sequence<MainTab> =
            values()
                .asSequence()
                .filter { it.tag != exceptTag }
    }
}