package com.brainstation23.topandroidrepositories.ui.home.presentation

import com.brainstation23.topandroidrepositories.R
import com.brainstation23.topandroidrepositories.data.network.response.GithubRepositoryResponse
import com.brainstation23.topandroidrepositories.ui.base.presenter.BasePresenter
import com.brainstation23.topandroidrepositories.ui.base.view.UiText
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

    override fun checkIsCached() {
        interactor?.apply {
            compositeDisposable.add(
                isCached().compose(schedulerProvider.ioToMainObservableScheduler())
                    .subscribe(::request, ::handleApiError)
            )
        }
    }

    override fun request(isCached: Boolean) {
        getView()?.let { view ->
            if (isCached) {
                view.success(UiText.StringResource(R.string.load_from_cached_data))
                view.onEvent()
                return
            }
            if (!view.isNetworkConnected()) {
                view.onEvent()
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
        getView()?.let { view ->
            view.success(UiText.StringResource(R.string.cached))
            interactor?.apply {
                compositeDisposable.addAll(
                    seedGitRepository(response.items)
                        .compose(schedulerProvider.ioToMainObservableScheduler())
                        .subscribe(view::refresh, ::handleApiError)
                )
            }
        }
    }
}