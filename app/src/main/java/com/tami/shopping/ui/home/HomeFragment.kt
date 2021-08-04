package com.tami.shopping.ui.home

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
import com.tami.shopping.R
import com.tami.shopping.base.ui.BindingFragment
import com.tami.shopping.databinding.HomeFrBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BindingFragment<HomeFrBinding>(R.layout.home_fr) {

    private val vm: HomeViewModel by viewModels()
    override fun onLoadOnce() {
        bb.vm = vm
        vm.homeDataList.observe(viewLifecycleOwner) {
            it?.let { list ->
                (bb.home.layoutManager as? GridLayoutManager)?.spanSizeLookup = object :
                    GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        val viewType = bb.home.adapter?.getItemViewType(position)
                        return when (viewType) {
                            HomeAdapter.BANNER_TYPE -> 2
                            else -> 1
                        }
                    }
                }

                bb.home.adapter = HomeAdapter().apply {
                    submitList(list)
                }
            }
        }
    }
}