package com.tami.shopping.utils.ext

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

/**
 * Debug 여부 확인
 * @return true : Debug, false: Release
 */
fun Context.isDebug(): Boolean {
    val isDebug: Boolean
    try {
        val appInfo = packageManager.getApplicationInfo(packageName, 0)
        isDebug = (0 != (appInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE))
    } catch (ne: PackageManager.NameNotFoundException) {
        return false
    }
    return isDebug
}

