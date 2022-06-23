package com.brainstation23.topandroidrepositories.di.builder

import com.brainstation23.topandroidrepositories.ui.home.HomeActivityModule
import com.brainstation23.topandroidrepositories.ui.home.view.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(HomeActivityModule::class)])
    abstract fun bindHomeActivity(): HomeActivity
}