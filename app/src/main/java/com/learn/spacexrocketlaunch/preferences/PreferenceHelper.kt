package com.learn.spacexrocketlaunch.preferences

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Inject

class PreferenceHelper @Inject constructor(context: Context) {
    var preferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREF_PROFILE, Context.MODE_PRIVATE)

    fun savePref(isFirstTimeLaunch: Boolean) {
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTimeLaunch)
        editor.apply()
        editor.commit()
    }

    fun getPref(): Boolean {
        return preferences.getBoolean(IS_FIRST_TIME_LAUNCH, false)
    }

    companion object {
        const val IS_FIRST_TIME_LAUNCH = "is_first_time_launch"
        const val SHARED_PREF_PROFILE = "launch_data_pref"
    }
}