package com.tami.shopping

import android.app.Application
import com.tami.shopping.utils.ext.isDebug
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class ShoppingApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        IS_DEBUG = isDebug()
        initTimber()
    }

    private fun initTimber() {
        if (IS_DEBUG)
            Timber.plant(Timber.DebugTree())
    }

    companion object {
        var IS_DEBUG = false
    }
}