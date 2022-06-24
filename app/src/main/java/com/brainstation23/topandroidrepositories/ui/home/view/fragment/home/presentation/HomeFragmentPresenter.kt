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

    override fun fetch(type: SortType) {
        getView()?.let { view ->
            interactor?.apply {
                val sortType = when (type) {
                    is SortType.None -> getSortType()
                    else -> type
                }
                setSortType(sortType)
                when (type) {
                    SortType.None -> compositeDisposable.add(
                        fetchGitRepository()
                            .compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe(view::parseData, ::throwIt)
                    )
                    SortType.DateAsc -> compositeDisposable.add(
                        fetchDateAsc()
                            .compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe(view::parseData, ::throwIt)
                    )
                    SortType.DateDesc -> compositeDisposable.add(
                        fetchDateDesc()
                            .compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe(view::parseData, ::throwIt)
                    )
                    SortType.StarAsc -> compositeDisposable.add(
                        fetchStarAsc()
                            .compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe(view::parseData, ::throwIt)
                    )
                    SortType.StarDesc -> compositeDisposable.add(
                        fetchStarDesc()
                            .compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe(view::parseData, ::throwIt)
                    )
                }
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
                        .subscribe(::saveToDb, ::handleApiError, view::hideSwipeLoading)
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


}