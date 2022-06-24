package com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.presentation

import com.brainstation23.topandroidrepositories.data.network.response.GithubRepositoryResponse
import com.brainstation23.topandroidrepositories.ui.base.presenter.BasePresenter
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.interactor.HomeFragmentMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.HomeFragmentMVPView
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.model.SortType
import com.brainstation23.topandroidrepositories.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeFragmentPresenter<V : HomeFragmentMVPView, I : HomeFragmentMVPInteractor> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable
) : BasePresenter<V, I>(
    interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable
), HomeFragmentMVPPresenter<V, I> {

    override fun fetch() {
        getView()?.let { view ->
            interactor?.apply {
                compositeDisposable.addAll(
                    fetchGitRepository()
                        .compose(schedulerProvider.ioToMainObservableScheduler())
                        .subscribe(view::parseData, ::throwIt)
                )
            }
        }
    }

    override fun request() {
        getView()?.let { view ->
            if (!view.isNetworkConnected()) {
                return
            }
            interactor?.apply {
                compositeDisposable.addAll(
                    searchApiCall()
                        .compose(schedulerProvider.ioToMainObservableScheduler())
                        .subscribe(::saveToDb, ::handleApiError)
                )
            }
        }
    }

    private fun saveToDb(response: GithubRepositoryResponse) {
        interactor?.apply {
            compositeDisposable.addAll(
                seedGitRepository(response.items)
                    .compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe({ fetch() }, ::handleApiError)
            )
        }
    }

    override fun sort(type: SortType) {
        interactor?.setSortType(type)
        fetch()
    }
}