package com.tami.shopping.ui.main

import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.tami.shopping.R
import com.tami.shopping.base.ui.BindingActivity
import com.tami.shopping.databinding.MainActBinding
import com.tami.shopping.view.BottomNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<MainActBinding>(R.layout.main_act) {

    private val navController: NavController by lazy {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_container)
            ?: throw IllegalStateException("the container MUST contain a fragment at least one")
        navHostFragment.findNavController()
    }

    override fun onLoadOnce() {
        navController.apply {
            navigatorProvider.addNavigator(
                BottomNavigator(R.id.nav_host_container, supportFragmentManager)
            )
            setGraph(R.navigation.mobile_navigation)
        }

        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_home, R.id.navigation_favorite)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        bb.navigation.setupWithNavController(navController)
    }
}