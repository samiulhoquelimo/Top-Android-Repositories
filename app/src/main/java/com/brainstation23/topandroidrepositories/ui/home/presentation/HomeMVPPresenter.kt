package com.brainstation23.topandroidrepositories.ui.home.presentation

import com.brainstation23.topandroidrepositories.ui.base.presenter.MVPPresenter
import com.brainstation23.topandroidrepositories.ui.home.interactor.HomeMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.HomeMVPView

interface HomeMVPPresenter<V : HomeMVPView, I : HomeMVPInteractor> : MVPPresenter<V, I>