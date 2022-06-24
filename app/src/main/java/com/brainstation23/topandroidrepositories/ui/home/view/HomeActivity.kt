package com.brainstation23.topandroidrepositories.ui.home.view

import android.os.Bundle
import android.view.View
import com.brainstation23.topandroidrepositories.R
import com.brainstation23.topandroidrepositories.databinding.ActivityHomeBinding
import com.brainstation23.topandroidrepositories.service.app.BrainApp
import com.brainstation23.topandroidrepositories.ui.base.view.DaggerActivity
import com.brainstation23.topandroidrepositories.ui.base.view.DaggerFragment
import com.brainstation23.topandroidrepositories.ui.home.interactor.HomeMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.presentation.HomeMVPPresenter
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.view.DetailsFragment
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.HomeFragment
import com.brainstation23.topandroidrepositories.ui.home.view.model.HomeEvent
import com.brainstation23.topandroidrepositories.utils.extension.replaceFragment
import javax.inject.Inject

class HomeActivity : DaggerActivity(), HomeMVPView {

    @Inject
    lateinit var presenter: HomeMVPPresenter<HomeMVPView, HomeMVPInteractor>

    private lateinit var binding: ActivityHomeBinding

    override fun getLayoutResourceId(): View {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun initView() = Unit

    override fun onEvent(event: HomeEvent) {
        BrainApp.navEvent = event
        showFragment(fragment(event))
    }

    override fun refresh(isNeeded: Boolean) = when (isNeeded) {
        true -> onEvent()
        false -> Unit
    }

    override fun showFragment(fragment: DaggerFragment) =
        replaceFragment(fragment = fragment, frameId = R.id.container)

    private fun fragment(homeEvent: HomeEvent): DaggerFragment = when (homeEvent) {
        is HomeEvent.Home -> HomeFragment.newInstance()
            .apply { event { event -> onEvent(event) } }
        is HomeEvent.Details -> DetailsFragment.newInstance()
            .apply { event { event -> onEvent(event) } }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
