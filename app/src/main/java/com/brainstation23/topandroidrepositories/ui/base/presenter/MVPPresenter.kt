package com.brainstation23.topandroidrepositories.ui.base.presenter

import com.brainstation23.topandroidrepositories.ui.base.interactor.MVPInteractor
import com.brainstation23.topandroidrepositories.ui.base.view.MVPView

interface MVPPresenter<V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

    fun handleApiError(throwable: Throwable)
}