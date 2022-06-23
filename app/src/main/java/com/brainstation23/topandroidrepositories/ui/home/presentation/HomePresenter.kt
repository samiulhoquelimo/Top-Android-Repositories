package com.brainstation23.topandroidrepositories.ui.home.presentation

import com.brainstation23.topandroidrepositories.ui.base.presenter.BasePresenter
import com.brainstation23.topandroidrepositories.ui.home.interactor.HomeMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.HomeMVPView
import com.brainstation23.topandroidrepositories.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomePresenter<V : HomeMVPView, I : HomeMVPInteractor> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable
) : BasePresenter<V, I>(
    interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable
), HomeMVPPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
        getView()?.initView()
    }
}