package com.brainstation23.topandroidrepositories.di.builder

import com.brainstation23.topandroidrepositories.ui.test_dialog.TestDialogModule
import com.brainstation23.topandroidrepositories.ui.test_dialog.view.TestDialog
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DialogBuilder {

    @ContributesAndroidInjector(modules = [(TestDialogModule::class)])
    abstract fun bindTestDialog(): TestDialog
}