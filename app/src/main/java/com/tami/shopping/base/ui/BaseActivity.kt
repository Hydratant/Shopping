package com.tami.shopping.base.ui

import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDialog
import androidx.lifecycle.Lifecycle
import com.tami.shopping.R
import timber.log.Timber

/**
 * 기본 Activity
 */
abstract class BaseActivity : AppCompatActivity() {

    protected open fun setSoftInputMode() {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN or WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setSoftInputMode()
        super.onCreate(savedInstanceState)
    }


    open fun showDialog(
        message: Any?,
        positiveButtonText: Any?,
        positiveListener: DialogInterface.OnClickListener? = null,
        negativeButtonText: Any? = null,
        negativeListener: DialogInterface.OnClickListener? = null
    ): AlertDialog {
        val dlg = getDialog(
            this,
            message,
            positiveButtonText,
            positiveListener,
            negativeButtonText,
            negativeListener
        ).apply {
            setCanceledOnTouchOutside(false)
            setCancelable(false)
        }
        if (lifecycle.currentState == Lifecycle.State.DESTROYED) {
            Timber.w("activity is Lifecycle destroyed")
            return dlg
        }
        if (isFinishing) {
            Timber.w("activity is isFinishing")
            return dlg
        }
        dlg.show()
        return dlg
    }

    open fun getDialog(
        context: Context,
        message: Any?,
        positiveButtonText: Any?,
        positiveListener: DialogInterface.OnClickListener? = null,
        negativeButtonText: Any? = null,
        negativeListener: DialogInterface.OnClickListener? = null
    ): AlertDialog {
        val builder = AlertDialog.Builder(context)
        if (message != null) builder.setMessage(getText(message))
        if (positiveButtonText != null) builder.setPositiveButton(
            getText(positiveButtonText),
            positiveListener
        )
        if (negativeButtonText != null) builder.setNegativeButton(
            getText(negativeButtonText),
            negativeListener
        )
        return builder.create()
    }

    private fun getText(text: Any?): CharSequence? {
        if (text == null) return null
        if (text is CharSequence) return text
        return if (text is Int) getString((text as Int?)!!) else text.toString()
    }

    val progress: AppCompatDialog by lazy { createProgress() }
    protected open fun createProgress(): AppCompatDialog {
        return AppCompatDialog(this, R.style.ProgressStyle).apply {
            window?.setBackgroundDrawable(ColorDrawable(0x00ff0000))
            val lp = WindowManager.LayoutParams().apply {
                copyFrom(window?.attributes)
                width = WindowManager.LayoutParams.MATCH_PARENT
                height = WindowManager.LayoutParams.MATCH_PARENT
                gravity = Gravity.CENTER
            }
            window?.attributes = lp
            setContentView(layoutInflater.inflate(R.layout.loading, null, false))
            setCanceledOnTouchOutside(false)
            setCancelable(true)
        }
    }

    open fun showProgress() {
        if (lifecycle.currentState == Lifecycle.State.DESTROYED) return
        if (isFinishing) return
        if (progress.isShowing) return
        progress.show()
    }

    open fun dismissProgress() {
        if (lifecycle.currentState == Lifecycle.State.DESTROYED) return
        if (isFinishing) return
        if (progress.isShowing) {
            progress.dismiss()
        }
    }
}