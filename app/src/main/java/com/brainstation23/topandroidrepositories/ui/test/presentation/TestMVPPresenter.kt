package com.brainstation23.topandroidrepositories.ui.test.presentation

import com.brainstation23.topandroidrepositories.ui.base.presenter.MVPPresenter
import com.brainstation23.topandroidrepositories.ui.test.interactor.TestMVPInteractor
import com.brainstation23.topandroidrepositories.ui.test.view.TestMVPView

interface TestMVPPresenter<V : TestMVPView, I : TestMVPInteractor> : MVPPresenter<V, I>