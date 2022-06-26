package com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.view

import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.data.network.response.model.Owner
import com.brainstation23.topandroidrepositories.ui.base.view.MVPView

interface DetailsFragmentMVPView : MVPView {

    fun getGitRepositoryId(): Int

    fun parseData(data: GitRepository)

    fun parseOwner(owner: Owner)
}