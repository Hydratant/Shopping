package com.tami.shopping.ui.main

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.tami.shopping.R
import com.tami.shopping.base.ui.BindingActivity
import com.tami.shopping.databinding.MainActBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<MainActBinding>(R.layout.main_act) {

    override fun onLoadOnce() {
        val navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_home, R.id.navigation_favorite)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bb.navigation.setupWithNavController(navController)
    }
}