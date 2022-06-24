package com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.presentation

import com.brainstation23.topandroidrepositories.ui.base.presenter.MVPPresenter
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.interactor.HomeFragmentMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.HomeFragmentMVPView
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.model.SortType

interface HomeFragmentMVPPresenter<V : HomeFragmentMVPView, I : HomeFragmentMVPInteractor> :
    MVPPresenter<V, I> {

    fun fetch(type: SortType = SortType.None)

    fun request()
}