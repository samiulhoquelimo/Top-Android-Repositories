package com.brainstation23.topandroidrepositories.data.preferences

import android.content.Context
import android.content.SharedPreferences
import com.brainstation23.topandroidrepositories.di.PreferenceInfo
import javax.inject.Inject

class AppPreferenceHelper @Inject constructor(
    context: Context,
    @PreferenceInfo private val prefFileName: String
) : PreferenceHelper {

    companion object {
        private const val PREF_KEY_LOGGED_IN = "is_login"
    }

    private val ctx = context

    private val mPrefs: SharedPreferences =
        ctx.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun isLoggedIn(): Boolean = mPrefs.getBoolean(PREF_KEY_LOGGED_IN, false)
}
