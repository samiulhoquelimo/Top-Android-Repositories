package com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brainstation23.topandroidrepositories.R
import com.brainstation23.topandroidrepositories.data.database.repository.git_repository.GitRepository
import com.brainstation23.topandroidrepositories.databinding.ListItemHomeBinding
import com.brainstation23.topandroidrepositories.ui.base.view.BaseViewHolder

class HomeAdapter(
    private val data: MutableList<GitRepository> = ArrayList()
) : RecyclerView.Adapter<BaseViewHolder>() {

    private var click: ((id: Int) -> Unit)? = null

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) = holder.onBind(position)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item_home, parent, false)
    )

    internal fun addDataToList(data: List<GitRepository>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : BaseViewHolder(view) {
        private val binding = ListItemHomeBinding.bind(view)

        override fun clear() {
            binding.tvName.text = ""
            binding.tvDate.text = ""
            binding.tvStar.text = ""
        }

        override fun onBind(position: Int) {
            val (_, name, _, date, _, star) = data[position]
            binding.tvName.text = name
            binding.tvDate.text = date
            binding.tvStar.text = star.toString()
        }
    }

    fun click(click: (id: Int) -> Unit) {
        this.click = click
    }
}

