package com.brainstation23.topandroidrepositories.ui.base.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.brainstation23.topandroidrepositories.R
import dagger.android.support.AndroidSupportInjection

abstract class DaggerFragment : Fragment(), MVPView {

    private var parentActivity: DaggerActivity? = null
    protected var savedInstanceState: Bundle? = null

    internal val p1: Int by lazy { ContextCompat.getColor(requireContext(), R.color.p1) }
    internal val p2: Int by lazy { ContextCompat.getColor(requireContext(), R.color.p2) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DaggerActivity) {
            val activity = context as DaggerActivity?
            this.parentActivity = activity
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.savedInstanceState = savedInstanceState
        setup(view)
    }

    override fun success(uiText: UiText) {
        parentActivity?.success(uiText)
    }

    override fun error(uiText: UiText) {
        parentActivity?.error(uiText)
    }

    override fun apiError(error: String?) {
        parentActivity?.apiError(error)
    }

    override fun noInternetAlert() {
        parentActivity?.noInternetAlert()
    }

    override fun isNetworkConnected(): Boolean = parentActivity?.isNetworkConnected() ?: true

    override fun getResString(uiText: UiText): String = parentActivity?.getResString(uiText) ?: ""

    abstract fun setup(view: View)
}