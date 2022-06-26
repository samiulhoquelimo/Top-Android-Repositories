package com.brainstation23.topandroidrepositories.di.builder

import com.brainstation23.topandroidrepositories.ui.home.HomeActivityModule
import com.brainstation23.topandroidrepositories.ui.home.view.HomeActivity
import com.brainstation23.topandroidrepositories.ui.preview.PreviewActivityModule
import com.brainstation23.topandroidrepositories.ui.preview.view.PreviewActivity
import com.brainstation23.topandroidrepositories.ui.test.TestActivityModule
import com.brainstation23.topandroidrepositories.ui.test.view.TestActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(HomeActivityModule::class)])
    abstract fun bindHomeActivity(): HomeActivity

    @ContributesAndroidInjector(modules = [(PreviewActivityModule::class)])
    abstract fun bindPreviewActivity(): PreviewActivity

    @ContributesAndroidInjector(modules = [(TestActivityModule::class)])
    abstract fun bindTestActivity(): TestActivity
}