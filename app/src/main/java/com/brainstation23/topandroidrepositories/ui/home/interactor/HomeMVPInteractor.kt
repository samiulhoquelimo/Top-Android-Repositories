package com.brainstation23.topandroidrepositories.ui.home.interactor

import com.brainstation23.topandroidrepositories.data.network.response.model.Item
import com.brainstation23.topandroidrepositories.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface HomeMVPInteractor : MVPInteractor {

    fun seedGitRepository(data: List<Item>?): Observable<Boolean>

    fun isCached(): Observable<Boolean>
}