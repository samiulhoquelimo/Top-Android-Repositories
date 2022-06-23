package com.brainstation23.topandroidrepositories.ui.home.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.brainstation23.topandroidrepositories.databinding.ActivityHomeBinding
import com.brainstation23.topandroidrepositories.ui.base.view.DaggerActivity
import com.brainstation23.topandroidrepositories.ui.home.interactor.HomeMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.presentation.HomeMVPPresenter
import javax.inject.Inject

class HomeActivity : DaggerActivity(), HomeMVPView {

    @Inject
    lateinit var presenter: HomeMVPPresenter<HomeMVPView, HomeMVPInteractor>

    private lateinit var binding: ActivityHomeBinding

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, HomeActivity::class.java)

        fun getStartCleanIntent(context: Context): Intent {
            val intent = Intent(context, HomeActivity::class.java)
            val flags =
                Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            intent.addFlags(flags)
            return intent
        }
    }

    override fun getLayoutResourceId(): View {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun initView() {
        binding.apply {

        }
    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
