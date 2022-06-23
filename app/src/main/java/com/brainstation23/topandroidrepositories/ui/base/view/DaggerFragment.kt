package com.brainstation23.topandroidrepositories.ui.base.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection

abstract class DaggerFragment : Fragment(), MVPView {

    private var parentActivity: DaggerActivity? = null
    protected var savedInstanceState: Bundle? = null

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
        setUp(view)
    }

    override fun isNetworkConnected(): Boolean = parentActivity?.isNetworkConnected() ?: true

    override fun getResString(uiText: UiText): String = parentActivity?.getResString(uiText) ?: ""

    abstract fun setUp(view: View)
}