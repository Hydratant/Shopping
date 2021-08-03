package com.tami.shopping.ui.main

import android.os.Bundle
import com.tami.shopping.R
import com.tami.shopping.base.ui.BindingActivity
import com.tami.shopping.databinding.MainActBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BindingActivity<MainActBinding>(R.layout.main_act) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_act)
    }

    override fun onLoadOnce() {
    }
}