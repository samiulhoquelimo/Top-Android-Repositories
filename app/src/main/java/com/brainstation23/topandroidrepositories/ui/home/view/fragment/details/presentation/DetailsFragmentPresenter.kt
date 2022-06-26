package com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.presentation

import com.brainstation23.topandroidrepositories.ui.base.presenter.BasePresenter
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.interactor.DetailsFragmentMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.view.DetailsFragmentMVPView
import com.brainstation23.topandroidrepositories.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailsFragmentPresenter<V : DetailsFragmentMVPView, I : DetailsFragmentMVPInteractor> @Inject internal constructor(
    interactor: I,
    schedulerProvider: SchedulerProvider,
    disposable: CompositeDisposable
) : BasePresenter<V, I>(
    interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable
), DetailsFragmentMVPPresenter<V, I> {

    override fun fetch() {
        getView()?.let { view ->
            interactor?.apply {
                compositeDisposable.addAll(
                    fetchGitRepository(view.getGitRepositoryId())
                        .compose(schedulerProvider.ioToMainObservableScheduler())
                        .subscribe(view::parseData, ::throwIt)
                )
            }
        }
    }

    override fun request(repo: String) {
        getView()?.let { view ->
            if (!view.isNetworkConnected()) {
                return
            }
            interactor?.apply {
                compositeDisposable.addAll(
                    usersApiCall(repo)
                        .compose(schedulerProvider.ioToMainObservableScheduler())
                        .subscribe(view::parseOwner, ::handleApiError)
                )
            }
        }
    }
}