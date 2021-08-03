package com.tami.shopping.base.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * DataBinding Fragment
 * @param layoutResId Binding layout ResId
 */
abstract class BindingFragment<B : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    BaseFragment() {

    protected lateinit var bb: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bb = DataBindingUtil.inflate(layoutInflater, layoutResId, container, false)
        return bb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bb.lifecycleOwner = viewLifecycleOwner
        onLoadOnce()
    }


    abstract fun onLoadOnce()
}