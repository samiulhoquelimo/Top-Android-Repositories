package com.brainstation23.topandroidrepositories.ui.preview.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.net.toUri
import com.brainstation23.topandroidrepositories.R
import com.brainstation23.topandroidrepositories.databinding.ActivityPreviewBinding
import com.brainstation23.topandroidrepositories.ui.base.view.DaggerActivity
import com.brainstation23.topandroidrepositories.ui.base.view.UiText
import com.brainstation23.topandroidrepositories.ui.preview.interactor.PreviewMVPInteractor
import com.brainstation23.topandroidrepositories.ui.preview.presentation.PreviewMVPPresenter
import me.relex.photodraweeview.PhotoDraweeView
import javax.inject.Inject

class PreviewActivity : DaggerActivity(), PreviewMVPView {

    @Inject
    lateinit var presenter: PreviewMVPPresenter<PreviewMVPView, PreviewMVPInteractor>

    private lateinit var binding: ActivityPreviewBinding

    companion object {
        private const val KEY_TITLE = "key_title"
        private const val KEY_URI = "key_uri"

        fun getStartIntent(context: Context, title: String, path: String): Intent =
            Intent(context, PreviewActivity::class.java).apply {
                putExtra(KEY_TITLE, title)
                putExtra(KEY_URI, path)
            }
    }

    override fun getLayoutResourceId(): View {
        binding = ActivityPreviewBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onAttach(this)
    }

    override fun initView() {
        binding.tvTitle.text = getParseTitle()
        val mPhotoDraweeView = findViewById<PhotoDraweeView>(R.id.photo_drawee_view)
        mPhotoDraweeView.setPhotoUri(getParseUri().toUri())

        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    override fun getParseTitle(): String =
        intent.extras?.getString(KEY_TITLE) ?: getResString(UiText.StringResource(R.string.preview))

    override fun getParseUri(): String = intent.extras?.getString(KEY_URI) ?: ""

    override fun onDestroy() {
        presenter.onDetach()
        super.onDestroy()
    }
}
