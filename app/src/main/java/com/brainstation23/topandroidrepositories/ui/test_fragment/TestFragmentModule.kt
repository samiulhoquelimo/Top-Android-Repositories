package com.brainstation23.topandroidrepositories.ui.test_fragment

import com.brainstation23.topandroidrepositories.ui.test_fragment.interactor.TestFragmentInteractor
import com.brainstation23.topandroidrepositories.ui.test_fragment.interactor.TestFragmentMVPInteractor
import com.brainstation23.topandroidrepositories.ui.test_fragment.presentation.TestFragmentMVPPresenter
import com.brainstation23.topandroidrepositories.ui.test_fragment.presentation.TestFragmentPresenter
import com.brainstation23.topandroidrepositories.ui.test_fragment.view.TestFragmentMVPView
import dagger.Module
import dagger.Provides

@Module
class TestFragmentModule {

    @Provides
    internal fun provideTestFragmentInteractor(
        interactor: TestFragmentInteractor
    ): TestFragmentMVPInteractor = interactor

    @Provides
    internal fun provideTestFragmentPresenter(
        presenter: TestFragmentPresenter<TestFragmentMVPView, TestFragmentMVPInteractor>
    ): TestFragmentMVPPresenter<TestFragmentMVPView, TestFragmentMVPInteractor> =
        presenter
}