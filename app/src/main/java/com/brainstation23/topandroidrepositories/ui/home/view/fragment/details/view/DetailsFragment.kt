package com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brainstation23.topandroidrepositories.databinding.FragmentDetailsBinding
import com.brainstation23.topandroidrepositories.ui.base.view.DaggerFragment
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.interactor.DetailsFragmentMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.presentation.DetailsFragmentMVPPresenter
import com.brainstation23.topandroidrepositories.ui.home.view.model.HomeEvent
import javax.inject.Inject

class DetailsFragment : DaggerFragment(), DetailsFragmentMVPView {

    @Inject
    lateinit var presenter:
            DetailsFragmentMVPPresenter<DetailsFragmentMVPView, DetailsFragmentMVPInteractor>

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private var event: ((event: HomeEvent) -> Unit)? = null

    companion object {
        const val TAG: String = "DetailsFragment"
        fun newInstance(): DetailsFragment = DetailsFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setup(view: View) {

    }

    fun event(event: (event: HomeEvent) -> Unit) {
        this.event = event
    }

    override fun onDestroyView() {
        presenter.onDetach()
        _binding = null
        super.onDestroyView()
    }
}