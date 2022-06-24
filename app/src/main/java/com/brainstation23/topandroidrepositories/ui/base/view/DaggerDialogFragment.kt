package com.brainstation23.topandroidrepositories.ui.base.view

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.DialogFragment
import dagger.android.support.AndroidSupportInjection

abstract class DaggerDialogFragment : DialogFragment(), MVPView {

    private var parentActivity: DaggerActivity? = null
    protected var savedInstanceState: Bundle? = null

    private val wrapContent = WindowManager.LayoutParams.WRAP_CONTENT

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is DaggerActivity) {
            val activity = context as DaggerActivity?
            this.parentActivity = activity
        }
    }

    override fun onResume() {
        super.onResume()
        dialog?.window?.apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            setLayout(9 * resources.displayMetrics.widthPixels / 10, wrapContent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        return super.onCreateView(inflater, container, savedInstanceState)
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

    override fun isNetworkConnected(): Boolean = parentActivity?.isNetworkConnected() ?: false

    override fun getResString(uiText: UiText): String =
        parentActivity?.getResString(uiText) ?: ""

    abstract fun setup(view: View)
}