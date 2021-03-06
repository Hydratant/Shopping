package com.tami.shopping.ui.favorite

import androidx.fragment.app.viewModels
import com.tami.shopping.R
import com.tami.shopping.base.ui.BindingFragment
import com.tami.shopping.databinding.FavoriteFrBinding
import com.tami.shopping.utils.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BindingFragment<FavoriteFrBinding>(R.layout.favorite_fr) {
    private val vm: FavoriteViewModel by viewModels()
    override fun onLoadOnce() {
        bb.vm = vm
        vm.showErrorMessage.observe(viewLifecycleOwner, EventObserver {
            showDialog(it, R.string.ok, null)
        })
    }

    companion object {
        const val TAG = "FavoriteFragment"
    }
}