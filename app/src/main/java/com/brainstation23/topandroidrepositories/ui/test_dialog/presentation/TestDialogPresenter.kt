package com.brainstation23.topandroidrepositories.ui.test_dialog.presentation

import com.brainstation23.topandroidrepositories.ui.base.presenter.BasePresenter
import com.brainstation23.topandroidrepositories.ui.test_dialog.interactor.TestDialogMVPInteractor
import com.brainstation23.topandroidrepositories.ui.test_dialog.view.TestDialogMVPView
import com.brainstation23.topandroidrepositories.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class TestDialogPresenter<V : TestDialogMVPView, I : TestDialogMVPInteractor> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable
) : BasePresenter<V, I>(
    interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable
), TestDialogMVPPresenter<V, I>