package com.tami.shopping.ui.main

import com.tami.shopping.R
import com.tami.shopping.base.ui.BindingActivity
import com.tami.shopping.databinding.MainActBinding
import com.tami.shopping.ui.favorite.FavoriteFragment
import com.tami.shopping.ui.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<MainActBinding>(R.layout.main_act) {

    override fun onLoadOnce() {

        bb.navigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {

                    val fragment = supportFragmentManager.findFragmentByTag("Home")
                    supportFragmentManager
                        .beginTransaction()
                        .add(R.id.container, HomeFragment(), "Home")
                        .commit()
                }
                R.id.navigation_favorite -> {
                    supportFragmentManager
                        .beginTransaction()
                        .add(R.id.container, FavoriteFragment(), "Favorite")
                        .commit()
                }
            }
            true
        }
        bb.navigation.setOnItemReselectedListener {

        }

        val fragment = supportFragmentManager.findFragmentByTag("Home")

    }
}