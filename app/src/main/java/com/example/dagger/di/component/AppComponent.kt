package com.example.dagger.di.component

import com.example.dagger.MyApplication
import com.example.dagger.di.modules.ActivityBuildersModule
import com.example.dagger.di.modules.DataModule
import com.example.dagger.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [AndroidInjectionModule::class
        , DataModule::class
        , ViewModelModule::class
        , ActivityBuildersModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApplication> {


    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(baseApplication: MyApplication): Builder

        fun build(): AppComponent
    }

}