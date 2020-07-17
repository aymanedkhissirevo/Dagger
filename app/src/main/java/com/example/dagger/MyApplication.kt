package com.example.dagger

import android.content.Context
import com.example.dagger.di.component.AppComponent
import com.example.dagger.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class MyApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication>? {
        appComponent = DaggerAppComponent.builder().application(this).build()
        return appComponent
    }



    companion object {
        lateinit var instance: MyApplication


        lateinit var appComponent: AppComponent
      lateinit var context :Context
}
}