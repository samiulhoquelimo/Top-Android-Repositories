package com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.core.os.bundleOf
import com.brainstation23.topandroidrepositories.R
import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.data.network.response.model.Owner
import com.brainstation23.topandroidrepositories.databinding.FragmentDetailsBinding
import com.brainstation23.topandroidrepositories.ui.base.view.DaggerFragment
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.interactor.DetailsFragmentMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.presentation.DetailsFragmentMVPPresenter
import com.brainstation23.topandroidrepositories.ui.home.view.model.HomeEvent
import com.brainstation23.topandroidrepositories.ui.preview.view.PreviewActivity
import com.brainstation23.topandroidrepositories.utils.extension.safeLet
import com.brainstation23.topandroidrepositories.utils.extension.toDateString
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
                name?.let { name ->
                    tvName.text = name
                    image?.let { url -> load(name, url) }
                    if (image.isNullOrEmpty()) {
                        presenter.request(name.split("/").first())
                    }
                }
                date?.let { date -> tvLastUpdate.text = date.toDateString() }
                star?.let { star -> tvStar.text = star.toString() }
                description?.let { description -> tvDescription.text = description }
            }
        }
    }

    override fun parseOwner(owner: Owner) {
        safeLet(owner.login, owner.avatar_url) { title, url -> load(title, url) }
    }

    private fun load(title: String, url: String) {
        Picasso.get().load(url)
            .error(R.drawable.ic_guthub)
            .into(binding.ivUserImage)

        binding.ivUserImage.setOnLongClickListener {
            popPreview(title, url)
            return@setOnLongClickListener true
        }
    }

    private fun popPreview(title: String, path: String) {
        val popup =
            PopupMenu(binding.ivUserImage.context, binding.ivUserImage)
        popup.inflate(R.menu.menu_preview)
        popup.setOnMenuItemClickListener { item: MenuItem? ->
            when (item?.itemId) {
                R.id.action_preview -> preview(title, path)
            }
            true
        }
        popup.show()
    }

    private fun preview(title: String, path: String) {
        startActivity(PreviewActivity.getStartIntent(requireContext(), title, path))
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