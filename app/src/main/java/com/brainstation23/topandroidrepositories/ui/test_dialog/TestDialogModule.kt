package com.brainstation23.topandroidrepositories.ui.test_dialog

import com.brainstation23.topandroidrepositories.ui.test_dialog.interactor.TestDialogInteractor
import com.brainstation23.topandroidrepositories.ui.test_dialog.interactor.TestDialogMVPInteractor
import com.brainstation23.topandroidrepositories.ui.test_dialog.presentation.TestDialogMVPPresenter
import com.brainstation23.topandroidrepositories.ui.test_dialog.presentation.TestDialogPresenter
import com.brainstation23.topandroidrepositories.ui.test_dialog.view.TestDialogMVPView
import dagger.Module
import dagger.Provides

@Module
class TestDialogModule {

    @Provides
    internal fun provideTestDialogInteractor(
        interactor: TestDialogInteractor
    ): TestDialogMVPInteractor = interactor

    @Provides
    internal fun provideTestDialogPresenter(
        presenter: TestDialogPresenter<TestDialogMVPView, TestDialogMVPInteractor>
    ): TestDialogMVPPresenter<TestDialogMVPView, TestDialogMVPInteractor> =
        presenter
}