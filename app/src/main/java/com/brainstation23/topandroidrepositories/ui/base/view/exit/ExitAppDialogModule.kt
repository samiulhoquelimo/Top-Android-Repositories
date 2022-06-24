package com.brainstation23.topandroidrepositories.ui.base.view.exit

import com.brainstation23.topandroidrepositories.ui.base.view.exit.interactor.ExitAppDialogInteractor
import com.brainstation23.topandroidrepositories.ui.base.view.exit.interactor.ExitAppDialogMVPInteractor
import com.brainstation23.topandroidrepositories.ui.base.view.exit.presentation.ExitAppDialogMVPPresenter
import com.brainstation23.topandroidrepositories.ui.base.view.exit.presentation.ExitAppDialogPresenter
import com.brainstation23.topandroidrepositories.ui.base.view.exit.view.ExitAppDialogMVPView
import dagger.Module
import dagger.Provides

@Module
class ExitAppDialogModule {

    @Provides
    internal fun provideExitAppDialogInteractor(
        interactor: ExitAppDialogInteractor
    ): ExitAppDialogMVPInteractor = interactor

    @Provides
    internal fun provideExitAppDialogPresenter(
        presenter: ExitAppDialogPresenter<ExitAppDialogMVPView, ExitAppDialogMVPInteractor>
    ): ExitAppDialogMVPPresenter<ExitAppDialogMVPView, ExitAppDialogMVPInteractor> =
        presenter
}