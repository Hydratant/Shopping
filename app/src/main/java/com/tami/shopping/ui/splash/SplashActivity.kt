package com.tami.shopping.ui.splash

import android.content.Intent
import androidx.activity.viewModels
import com.tami.shopping.R
import com.tami.shopping.base.ui.BindingActivity
import com.tami.shopping.databinding.SplashActBinding
import com.tami.shopping.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BindingActivity<SplashActBinding>(R.layout.splash_act) {
    private val vm: SplashViewModel by viewModels()
    override fun onLoadOnce() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}