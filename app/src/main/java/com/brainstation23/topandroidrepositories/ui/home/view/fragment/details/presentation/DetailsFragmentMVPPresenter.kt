package com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.presentation

import com.brainstation23.topandroidrepositories.ui.base.presenter.MVPPresenter
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.interactor.DetailsFragmentMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.view.DetailsFragmentMVPView

interface DetailsFragmentMVPPresenter<V : DetailsFragmentMVPView, I : DetailsFragmentMVPInteractor> :
    MVPPresenter<V, I> {

    fun fetch()
}