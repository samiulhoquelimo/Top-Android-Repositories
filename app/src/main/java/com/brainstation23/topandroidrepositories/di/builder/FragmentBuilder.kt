package com.brainstation23.topandroidrepositories.di.builder

import com.brainstation23.topandroidrepositories.ui.test_fragment.TestFragmentModule
import com.brainstation23.topandroidrepositories.ui.test_fragment.view.TestFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector(modules = [(TestFragmentModule::class)])
    abstract fun bindTestFragment(): TestFragment
}