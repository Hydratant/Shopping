package com.tami.shopping.ui.home

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.tami.shopping.R
import com.tami.shopping.base.ui.BindingFragment
import com.tami.shopping.databinding.HomeFrBinding
import com.tami.shopping.utils.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BindingFragment<HomeFrBinding>(R.layout.home_fr) {

    private val vm: HomeViewModel by viewModels()
    override fun onLoadOnce() {
        bb.vm = vm
        vm.showErrorMessage.observe(viewLifecycleOwner, EventObserver {
            showDialog(it, R.string.ok, null)
        })
        vm.showToastMessage.observe(viewLifecycleOwner, EventObserver {
            Toast.makeText(requireContext(), getText(it), Toast.LENGTH_SHORT).show()
        })
        vm.bannerRefresh.observe(viewLifecycleOwner, EventObserver {
            (bb.home.adapter as? HomeAdapter)?.onViewPagerRefresh?.invoke()
        })
    }

    companion object {
        const val TAG = "HomeFragment"
    }
}