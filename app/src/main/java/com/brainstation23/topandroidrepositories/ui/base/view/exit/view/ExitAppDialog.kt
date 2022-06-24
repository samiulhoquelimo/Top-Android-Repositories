package com.brainstation23.topandroidrepositories.ui.base.view.exit.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.brainstation23.topandroidrepositories.databinding.DialogExitAppBinding
import com.brainstation23.topandroidrepositories.ui.base.view.DaggerDialogFragment
import com.brainstation23.topandroidrepositories.ui.base.view.exit.interactor.ExitAppDialogMVPInteractor
import com.brainstation23.topandroidrepositories.ui.base.view.exit.presentation.ExitAppDialogMVPPresenter
import javax.inject.Inject

class ExitAppDialog : DaggerDialogFragment(), ExitAppDialogMVPView {

    @Inject
    lateinit var presenter:
            ExitAppDialogMVPPresenter<ExitAppDialogMVPView, ExitAppDialogMVPInteractor>

    private var _binding: DialogExitAppBinding? = null
    private val binding get() = _binding!!

    private var exit: (() -> Unit)? = null

    companion object {
        const val TAG: String = "ExitAppDialog"
        fun newInstance(): ExitAppDialog = ExitAppDialog()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = DialogExitAppBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        presenter.onAttach(this)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun setup(view: View) {
        binding.tvOk.setOnClickListener { dismiss().also { exit?.invoke() } }
        binding.tvCancel.setOnClickListener { dismiss() }
    }

    fun exit(exit: () -> Unit) {
        this.exit = exit
    }

    override fun onDestroyView() {
        presenter.onDetach()
        _binding = null
        super.onDestroyView()
    }
}