package com.tami.shopping.ui.home

import androidx.fragment.app.viewModels
import com.tami.shopping.R
import com.tami.shopping.base.ui.BindingFragment
import com.tami.shopping.databinding.HomeFrBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BindingFragment<HomeFrBinding>(R.layout.home_fr) {

    private val vm: HomeViewModel by viewModels()
    override fun onLoadOnce() {
        bb.vm = vm
    }
}