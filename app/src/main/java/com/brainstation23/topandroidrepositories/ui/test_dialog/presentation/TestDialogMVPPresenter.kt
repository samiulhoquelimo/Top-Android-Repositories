package com.brainstation23.topandroidrepositories.ui.test_dialog.presentation

import com.brainstation23.topandroidrepositories.ui.base.presenter.MVPPresenter
import com.brainstation23.topandroidrepositories.ui.test_dialog.interactor.TestDialogMVPInteractor
import com.brainstation23.topandroidrepositories.ui.test_dialog.view.TestDialogMVPView

interface TestDialogMVPPresenter<V : TestDialogMVPView, I : TestDialogMVPInteractor> :
    MVPPresenter<V, I>