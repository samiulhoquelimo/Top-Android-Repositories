package com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view

import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.ui.base.view.MVPView

interface HomeFragmentMVPView : MVPView {

    fun parseData(data: List<GitRepository>)
}