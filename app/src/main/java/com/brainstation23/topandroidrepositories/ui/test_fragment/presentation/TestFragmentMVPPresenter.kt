package com.brainstation23.topandroidrepositories.ui.test_fragment.presentation

import com.brainstation23.topandroidrepositories.ui.base.presenter.MVPPresenter
import com.brainstation23.topandroidrepositories.ui.test_fragment.interactor.TestFragmentMVPInteractor
import com.brainstation23.topandroidrepositories.ui.test_fragment.view.TestFragmentMVPView

interface TestFragmentMVPPresenter<V : TestFragmentMVPView, I : TestFragmentMVPInteractor> :
    MVPPresenter<V, I>