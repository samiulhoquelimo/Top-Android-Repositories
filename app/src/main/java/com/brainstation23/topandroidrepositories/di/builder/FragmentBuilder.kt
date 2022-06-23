package com.brainstation23.topandroidrepositories.di.builder

import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.DetailsFragmentModule
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.details.view.DetailsFragment
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.HomeFragmentModule
import com.brainstation23.topandroidrepositories.ui.home.view.fragment.home.view.HomeFragment
import com.brainstation23.topandroidrepositories.ui.test_fragment.TestFragmentModule
import com.brainstation23.topandroidrepositories.ui.test_fragment.view.TestFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [(HomeFragmentModule::class)])
    abstract fun bindHomeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [(DetailsFragmentModule::class)])
    abstract fun bindDetailsFragment(): DetailsFragment

    @ContributesAndroidInjector(modules = [(TestFragmentModule::class)])
    abstract fun bindTestFragment(): TestFragment
}