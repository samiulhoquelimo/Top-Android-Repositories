package com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.brainstation23.topandroidrepositories.R
import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.databinding.FragmentDetailsBinding
import com.brainstation23.topandroidrepositories.ui.base.view.DaggerFragment
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.interactor.DetailsFragmentMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.presentation.DetailsFragmentMVPPresenter
import com.brainstation23.topandroidrepositories.ui.home.view.model.HomeEvent
import com.squareup.picasso.Picasso
import javax.inject.Inject

class DetailsFragment : DaggerFragment(), DetailsFragmentMVPView {

    @Inject
    lateinit var presenter:
            DetailsFragmentMVPPresenter<DetailsFragmentMVPView, DetailsFragmentMVPInteractor>

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private var event: ((event: HomeEvent) -> Unit)? = null

    companion object {
        private const val KEY_ID = "key_id"

        const val TAG: String = "DetailsFragment"
        fun newInstance(id: Int): DetailsFragment = DetailsFragment().apply {
            arguments = bundleOf(KEY_ID to id)
        }
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
        binding.ivBack.setOnClickListener { event?.invoke(HomeEvent.Home) }
        presenter.fetch()
    }

    override fun parseData(data: GitRepository) {
        binding.apply {
            with(data) {
                name?.let { name -> tvName.text = name }
                date?.let { date -> tvLastUpdate.text = date }
                description?.let { description -> tvDescription.text = description }
                image?.let { image -> load(image) }
            }
        }
    }

    private fun load(image: String) {
        Picasso.get().load(image)
            .error(R.drawable.ic_profile_user)
            .into(binding.ivUserImage)
    }

    override fun getGitRepositoryId(): Int = arguments?.getInt(KEY_ID) ?: 0

    fun event(event: (event: HomeEvent) -> Unit) {
        this.event = event
    }

    override fun onDestroyView() {
        presenter.onDetach()
        _binding = null
        super.onDestroyView()
    }
}