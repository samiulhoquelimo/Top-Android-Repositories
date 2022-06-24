package com.brainstation23.topandroidrepositories.data.preferences

import android.content.Context
import android.content.SharedPreferences
import com.brainstation23.topandroidrepositories.di.PreferenceInfo
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.model.SortType
import com.brainstation23.topandroidrepositories.utils.extension.toSortType
import javax.inject.Inject

class AppPreferenceHelper @Inject constructor(
    context: Context,
    @PreferenceInfo private val prefFileName: String
) : PreferenceHelper {

    companion object {
        private const val PREF_KEY_SORT_TYPE = "sort_type"
    }

    private val ctx = context

    private val mPrefs: SharedPreferences =
        ctx.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override fun getSortType(): SortType =
        mPrefs.getInt(PREF_KEY_SORT_TYPE, SortType.None.type).toSortType()

    override fun setSortType(type: SortType) = mPrefs.edit()
        .putInt(PREF_KEY_SORT_TYPE, type.type).apply()
}

