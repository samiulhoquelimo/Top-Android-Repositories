package com.brainstation23.topandroidrepositories.ui.base.view.exit.presentation

import com.brainstation23.topandroidrepositories.ui.base.presenter.MVPPresenter
import com.brainstation23.topandroidrepositories.ui.base.view.exit.interactor.ExitAppDialogMVPInteractor
import com.brainstation23.topandroidrepositories.ui.base.view.exit.view.ExitAppDialogMVPView

interface ExitAppDialogMVPPresenter<V : ExitAppDialogMVPView, I : ExitAppDialogMVPInteractor> :
    MVPPresenter<V, I>