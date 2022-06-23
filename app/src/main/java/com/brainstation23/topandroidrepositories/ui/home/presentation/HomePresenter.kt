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
        checkIsCached()
    }

    /**
     * Checking if not cached, then api request calling
     */
    override fun checkIsCached() {
        interactor?.apply {
            compositeDisposable.add(
                isCached().compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe(::request, ::handleApiError)
            )
        }
    }

    /**
     * Api request calling, if not cached and net connection available
     */
    override fun request(isCached: Boolean) {
        getView()?.let { view ->
            if (isCached) {
                return
            }
            if (!view.isNetworkConnected()) {
                return
            }
            interactor?.apply {
                compositeDisposable.addAll(
                    searchApiCall()
                        .compose(schedulerProvider.ioToMainObservableScheduler())
                        .subscribe({ response ->
                            response.items?.let { data -> seedGitRepository(data) }
                        }, ::handleApiError)
                )
            }
        }
    }
}