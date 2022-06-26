package com.brainstation23.topandroidrepositories.ui.preview

import com.brainstation23.topandroidrepositories.ui.preview.interactor.PreviewInteractor
import com.brainstation23.topandroidrepositories.ui.preview.interactor.PreviewMVPInteractor
import com.brainstation23.topandroidrepositories.ui.preview.presentation.PreviewMVPPresenter
import com.brainstation23.topandroidrepositories.ui.preview.presentation.PreviewPresenter
import com.brainstation23.topandroidrepositories.ui.preview.view.PreviewMVPView
import dagger.Module
import dagger.Provides

@Module
class PreviewActivityModule {

    @Provides
    internal fun providePreviewInteractor(
        interactor: PreviewInteractor
    ): PreviewMVPInteractor = interactor

    @Provides
    internal fun providePreviewPresenter(
        presenter: PreviewPresenter<PreviewMVPView, PreviewMVPInteractor>
    ): PreviewMVPPresenter<PreviewMVPView, PreviewMVPInteractor> = presenter
}