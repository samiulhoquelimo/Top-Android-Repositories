package com.brainstation23.topandroidrepositories.ui.test.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.brainstation23.topandroidrepositories.databinding.ActivityTestBinding
import com.brainstation23.topandroidrepositories.ui.base.view.DaggerActivity
import com.brainstation23.topandroidrepositories.ui.test.interactor.TestMVPInteractor
import com.brainstation23.topandroidrepositories.ui.test.presentation.TestMVPPresenter
import javax.inject.Inject

class TestActivity : DaggerActivity(), TestMVPView {

    @Inject
    lateinit var presenter: TestMVPPresenter<TestMVPView, TestMVPInteractor>

    private lateinit var binding: ActivityTestBinding

    companion object {
        fun getStartIntent(context: Context): Intent = Intent(context, TestActivity::class.java)
    }

    override fun getLayoutResourceId(): View {
        binding = ActivityTestBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun initView() {

    }

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
