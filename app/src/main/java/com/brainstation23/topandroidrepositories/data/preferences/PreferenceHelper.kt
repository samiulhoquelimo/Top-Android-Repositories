package com.brainstation23.topandroidrepositories.data.preferences

import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.model.SortType

interface PreferenceHelper {

    fun getSortType(): SortType

    fun setSortType(type: SortType)
}