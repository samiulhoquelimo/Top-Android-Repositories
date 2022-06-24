package com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.brainstation23.topandroidrepositories.R
import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.databinding.FragmentHomeBinding
import com.brainstation23.topandroidrepositories.ui.base.view.DaggerFragment
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.interactor.HomeFragmentMVPInteractor
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.presentation.HomeFragmentMVPPresenter
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.adapter.HomeAdapter
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.model.SortType
import com.brainstation23.topandroidrepositories.ui.home.view.model.HomeEvent
import javax.inject.Inject

class HomeFragment : DaggerFragment(), HomeFragmentMVPView {

    @Inject
    lateinit var presenter:
            HomeFragmentMVPPresenter<HomeFragmentMVPView, HomeFragmentMVPInteractor>

    @Inject
    lateinit var adapter: HomeAdapter

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var event: ((event: HomeEvent) -> Unit)? = null

    companion object {
        const val TAG: String = "HomeFragment"
        fun newInstance(): HomeFragment = HomeFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setup(view: View) {
        binding.apply {
            listRepository.apply {
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                itemAnimator = DefaultItemAnimator()
                isNestedScrollingEnabled = true
                adapter = this@HomeFragment.adapter.apply { click { id -> details(id) } }
            }

            swipeRefreshLayout.setColorSchemeColors(p1, p2)
            swipeRefreshLayout.setOnRefreshListener { presenter.request() }

            ivSort.setOnClickListener { popup() }
            ivSync.setOnClickListener { presenter.request() }
        }
        presenter.fetch()
    }

    override fun parseData(data: List<GitRepository>) {
        adapter.addDataToList(data)
    }

    override fun showSwipeLoading() {
        binding.swipeRefreshLayout.isRefreshing = true
    }

    override fun hideSwipeLoading() {
        binding.swipeRefreshLayout.isRefreshing = false
    }

    private fun details(id: Int) {
        event?.invoke(HomeEvent.Details(id))
    }

    private fun popup() {
        val popup = PopupMenu(requireContext(), binding.ivSort)
        popup.inflate(R.menu.menu_pop_sort)
        popup.setOnMenuItemClickListener { item: MenuItem? ->
            when (item?.itemId) {
                R.id.action_sort_by_date -> presenter.sort(SortType.Date)
                R.id.action_sort_by_star -> presenter.sort(SortType.Star)
            }
            true
        }
        popup.show()
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