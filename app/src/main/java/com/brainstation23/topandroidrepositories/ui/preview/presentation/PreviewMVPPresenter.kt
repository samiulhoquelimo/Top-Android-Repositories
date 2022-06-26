package com.brainstation23.topandroidrepositories.ui.preview.presentation

import com.brainstation23.topandroidrepositories.ui.base.presenter.MVPPresenter
import com.brainstation23.topandroidrepositories.ui.preview.interactor.PreviewMVPInteractor
import com.brainstation23.topandroidrepositories.ui.preview.view.PreviewMVPView

interface PreviewMVPPresenter<V : PreviewMVPView, I : PreviewMVPInteractor> : MVPPresenter<V, I>