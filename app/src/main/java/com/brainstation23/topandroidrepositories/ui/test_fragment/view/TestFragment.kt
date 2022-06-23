package com.brainstation23.topandroidrepositories.ui.test_fragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brainstation23.topandroidrepositories.databinding.FragmentTestBinding
import com.brainstation23.topandroidrepositories.ui.base.view.DaggerFragment
import com.brainstation23.topandroidrepositories.ui.test_fragment.interactor.TestFragmentMVPInteractor
import com.brainstation23.topandroidrepositories.ui.test_fragment.presentation.TestFragmentMVPPresenter
import javax.inject.Inject

class TestFragment : DaggerFragment(), TestFragmentMVPView {

    @Inject
    lateinit var presenter:
            TestFragmentMVPPresenter<TestFragmentMVPView, TestFragmentMVPInteractor>

    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val TAG: String = "TestFragment"
        fun newInstance(): TestFragment = TestFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTestBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setup(view: View) {

    }

    override fun onDestroyView() {
        presenter.onDetach()
        _binding = null
        super.onDestroyView()
    }
}