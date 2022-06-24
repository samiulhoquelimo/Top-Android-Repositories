package com.brainstation23.topandroidrepositories.ui.base.view.exit.presentation

import com.brainstation23.topandroidrepositories.ui.base.presenter.BasePresenter
import com.brainstation23.topandroidrepositories.ui.base.view.exit.interactor.ExitAppDialogMVPInteractor
import com.brainstation23.topandroidrepositories.ui.base.view.exit.view.ExitAppDialogMVPView
import com.brainstation23.topandroidrepositories.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ExitAppDialogPresenter<V : ExitAppDialogMVPView, I : ExitAppDialogMVPInteractor> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable
) : BasePresenter<V, I>(
    interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable
), ExitAppDialogMVPPresenter<V, I>