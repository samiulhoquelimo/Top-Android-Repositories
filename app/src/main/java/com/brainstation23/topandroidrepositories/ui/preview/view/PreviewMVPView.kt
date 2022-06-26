package com.brainstation23.topandroidrepositories.ui.preview.view

import com.brainstation23.topandroidrepositories.ui.base.view.MVPView

interface PreviewMVPView : MVPView {

    fun initView()

    fun getParseTitle(): String

    fun getParseUri(): String
}