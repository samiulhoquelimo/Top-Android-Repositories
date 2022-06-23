package com.brainstation23.topandroidrepositories.ui.home.view.fragment.details

import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.interactor.DetailsFragmentInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.interactor.DetailsFragmentMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.presentation.DetailsFragmentMVPPresenter
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.presentation.DetailsFragmentPresenter
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.view.DetailsFragmentMVPView
import dagger.Module
import dagger.Provides

@Module
class DetailsFragmentModule {

    @Provides
    internal fun provideDetailsFragmentInteractor(
        interactor: DetailsFragmentInteractor
    ): DetailsFragmentMVPInteractor = interactor

    @Provides
    internal fun provideDetailsFragmentPresenter(
        presenter: DetailsFragmentPresenter<DetailsFragmentMVPView, DetailsFragmentMVPInteractor>
    ): DetailsFragmentMVPPresenter<DetailsFragmentMVPView, DetailsFragmentMVPInteractor> =
        presenter
}