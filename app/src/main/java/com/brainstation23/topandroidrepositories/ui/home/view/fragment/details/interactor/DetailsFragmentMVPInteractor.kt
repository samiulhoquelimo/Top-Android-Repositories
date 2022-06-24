package com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.interactor

import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface DetailsFragmentMVPInteractor : MVPInteractor {

    fun fetchGitRepository(id: Int): Observable<GitRepository>
}