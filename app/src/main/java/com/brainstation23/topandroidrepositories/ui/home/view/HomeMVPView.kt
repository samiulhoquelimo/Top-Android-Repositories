package com.brainstation23.topandroidrepositories.ui.home.view

import com.brainstation23.topandroidrepositories.service.app.BrainApp
import com.brainstation23.topandroidrepositories.ui.base.view.DaggerFragment
import com.brainstation23.topandroidrepositories.ui.base.view.MVPView
import com.brainstation23.topandroidrepositories.ui.home.view.model.HomeEvent

interface HomeMVPView : MVPView {

    fun initView()

    fun onEvent(event: HomeEvent = BrainApp.navEvent)

    fun showFragment(fragment: DaggerFragment)

    fun refresh(isNeeded: Boolean)
}