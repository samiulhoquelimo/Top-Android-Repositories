package com.brainstation23.topandroidrepositories.ui.home.view.fragment.home

import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.interactor.HomeFragmentInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.interactor.HomeFragmentMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.presentation.HomeFragmentMVPPresenter
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.presentation.HomeFragmentPresenter
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.HomeFragmentMVPView
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.adapter.HomeAdapter
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {

    @Provides
    internal fun provideHomeFragmentInteractor(
        interactor: HomeFragmentInteractor
    ): HomeFragmentMVPInteractor = interactor

    @Provides
    internal fun provideHomeFragmentPresenter(
        presenter: HomeFragmentPresenter<HomeFragmentMVPView, HomeFragmentMVPInteractor>
    ): HomeFragmentMVPPresenter<HomeFragmentMVPView, HomeFragmentMVPInteractor> =
        presenter

    @Provides
    internal fun provideHomeAdapter(): HomeAdapter = HomeAdapter()
}