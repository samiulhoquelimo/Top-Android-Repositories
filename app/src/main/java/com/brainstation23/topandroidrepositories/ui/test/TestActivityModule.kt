package com.brainstation23.topandroidrepositories.ui.test

import com.brainstation23.topandroidrepositories.ui.test.interactor.TestInteractor
import com.brainstation23.topandroidrepositories.ui.test.interactor.TestMVPInteractor
import com.brainstation23.topandroidrepositories.ui.test.presentation.TestMVPPresenter
import com.brainstation23.topandroidrepositories.ui.test.presentation.TestPresenter
import com.brainstation23.topandroidrepositories.ui.test.view.TestMVPView
import dagger.Module
import dagger.Provides

@Module
class TestActivityModule {

    @Provides
    internal fun provideTestInteractor(
        interactor: TestInteractor
    ): TestMVPInteractor = interactor

    @Provides
    internal fun provideTestPresenter(
        presenter: TestPresenter<TestMVPView, TestMVPInteractor>
    ): TestMVPPresenter<TestMVPView, TestMVPInteractor> = presenter
}