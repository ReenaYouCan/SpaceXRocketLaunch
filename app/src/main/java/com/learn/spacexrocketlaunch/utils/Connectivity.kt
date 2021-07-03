package com.learn.spacexrocketlaunch.utils

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

open class Connectivity @Inject constructor(private val context: Context) {
    fun hasNetworkAccess(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val info = connectivityManager.activeNetworkInfo
        return info != null && info.isConnected
    }
}