package com.tami.shopping.base.ui

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * DataBinding Activity
 * @param layoutResId Binding layout ResId
 */
abstract class BindingActivity<B : ViewDataBinding>(@LayoutRes private val layoutResId: Int) :
    BaseActivity() {

    protected lateinit var bb: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bb = DataBindingUtil.setContentView(this, layoutResId)
        bb.apply { this.lifecycleOwner = this@BindingActivity }
        onLoadOnce()
    }

    abstract fun onLoadOnce()
}