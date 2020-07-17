package com.example.dagger.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dagger.di.viewmodels.FactoryViewModel
import com.example.dagger.di.viewmodels.ViewModelKey
import com.example.dagger.viewModels.ApiViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: FactoryViewModel): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(ApiViewModel::class)
    abstract fun providesApiViewModel(apiViewModel: ApiViewModel): ViewModel




}