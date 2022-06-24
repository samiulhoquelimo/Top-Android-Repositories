package com.brainstation23.topandroidrepositories.ui.base.view.exit.interactor

import com.brainstation23.topandroidrepositories.data.network.ApiHelper
import com.brainstation23.topandroidrepositories.data.preferences.PreferenceHelper
import com.brainstation23.topandroidrepositories.ui.base.interactor.BaseInteractor
import javax.inject.Inject

class ExitAppDialogInteractor @Inject constructor(
    preferenceHelper: PreferenceHelper,
    apiHelper: ApiHelper
) : BaseInteractor(preferenceHelper, apiHelper), ExitAppDialogMVPInteractor