package com.brainstation23.topandroidrepositories.ui.test_fragment.presentation

import com.brainstation23.topandroidrepositories.ui.base.presenter.BasePresenter
import com.brainstation23.topandroidrepositories.ui.test_fragment.interactor.TestFragmentMVPInteractor
import com.brainstation23.topandroidrepositories.ui.test_fragment.view.TestFragmentMVPView
import com.brainstation23.topandroidrepositories.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class TestFragmentPresenter<V : TestFragmentMVPView, I : TestFragmentMVPInteractor> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable
) : BasePresenter<V, I>(
    interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable
), TestFragmentMVPPresenter<V, I>