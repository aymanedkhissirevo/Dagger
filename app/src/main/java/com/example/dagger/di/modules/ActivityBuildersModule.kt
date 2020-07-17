package com.example.dagger.di.modules

import com.example.dagger.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

}