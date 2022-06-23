package com.brainstation23.topandroidrepositories.ui.test_dialog.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.brainstation23.topandroidrepositories.databinding.DialogTestBinding
import com.brainstation23.topandroidrepositories.ui.base.view.DaggerDialogFragment
import com.brainstation23.topandroidrepositories.ui.test_dialog.interactor.TestDialogMVPInteractor
import com.brainstation23.topandroidrepositories.ui.test_dialog.presentation.TestDialogMVPPresenter
import javax.inject.Inject

class TestDialog : DaggerDialogFragment(), TestDialogMVPView {

    @Inject
    lateinit var presenter:
            TestDialogMVPPresenter<TestDialogMVPView, TestDialogMVPInteractor>

    private var _binding: DialogTestBinding? = null
    private val binding get() = _binding!!

    companion object {
        const val TAG: String = "TestDialog"
        fun newInstance(): TestDialog = TestDialog()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = DialogTestBinding.inflate(inflater, container, false)
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

    }

    override fun onDestroyView() {
        presenter.onDetach()
        _binding = null
        super.onDestroyView()
    }
}