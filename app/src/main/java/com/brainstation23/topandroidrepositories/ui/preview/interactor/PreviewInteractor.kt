package com.brainstation23.topandroidrepositories.ui.preview.interactor

import com.brainstation23.topandroidrepositories.data.network.ApiHelper
import com.brainstation23.topandroidrepositories.data.preferences.PreferenceHelper
import com.brainstation23.topandroidrepositories.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class PreviewInteractor @Inject constructor(
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BaseInteractor(preferenceHelper, apiHelper), PreviewMVPInteractor