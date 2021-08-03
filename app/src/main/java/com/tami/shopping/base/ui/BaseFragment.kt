package com.tami.shopping.base.ui

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.tami.shopping.base.ui.BaseActivity

abstract class BaseFragment : Fragment() {
    private val baseActivity: BaseActivity by lazy { requireActivity() as BaseActivity }
    fun showProgress() {
        baseActivity.showProgress()
    }

    fun dismissProgress() {
        baseActivity.dismissProgress()
    }

    fun showDialog(
        message: Any?,
        positiveButtonText: Any?,
        positiveListener: DialogInterface.OnClickListener? = null,
        negativeButtonText: Any? = null,
        negativeListener: DialogInterface.OnClickListener? = null,
    ): AlertDialog {
        return baseActivity.showDialog(
            message,
            positiveButtonText,
            positiveListener,
            negativeButtonText,
            negativeListener
        )
    }
}