package com.brainstation23.topandroidrepositories.ui.preview.presentation

import com.brainstation23.topandroidrepositories.ui.base.presenter.BasePresenter
import com.brainstation23.topandroidrepositories.ui.preview.interactor.PreviewMVPInteractor
import com.brainstation23.topandroidrepositories.ui.preview.view.PreviewMVPView
import com.brainstation23.topandroidrepositories.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PreviewPresenter<V : PreviewMVPView, I : PreviewMVPInteractor> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable
) : BasePresenter<V, I>(
    interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable
), PreviewMVPPresenter<V, I> {

    override fun onAttach(view: V?) {
        super.onAttach(view)
        getView()?.initView()
    }
}