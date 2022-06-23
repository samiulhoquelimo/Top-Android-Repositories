package com.brainstation23.topandroidrepositories.ui.base.interactor

import com.brainstation23.topandroidrepositories.data.network.ApiHelper
import com.brainstation23.topandroidrepositories.data.preferences.PreferenceHelper

open class BaseInteractor(
    val preferenceHelper: PreferenceHelper,
    val apiHelper: ApiHelper
) : MVPInteractor