package com.brainstation23.topandroidrepositories.ui.home

import com.brainstation23.topandroidrepositories.ui.home.interactor.HomeInteractor
import com.brainstation23.topandroidrepositories.ui.home.interactor.HomeMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.presentation.HomeMVPPresenter
import com.brainstation23.topandroidrepositories.ui.home.presentation.HomePresenter
import com.brainstation23.topandroidrepositories.ui.home.view.HomeMVPView
import dagger.Module
import dagger.Provides

@Module
class HomeActivityModule {

    @Provides
    internal fun provideHomeInteractor(
        interactor: HomeInteractor
    ): HomeMVPInteractor = interactor

    @Provides
    internal fun provideHomePresenter(
        presenter: HomePresenter<HomeMVPView, HomeMVPInteractor>
    ): HomeMVPPresenter<HomeMVPView, HomeMVPInteractor> = presenter
}