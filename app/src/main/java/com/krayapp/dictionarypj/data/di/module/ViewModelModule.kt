package com.krayapp.dictionarypj.data.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.krayapp.dictionarypj.viewmodel.MainFragmentViewModel
import com.krayapp.dictionarypj.viewmodel.ViewModelFactory
import com.krayapp.dictionarypj.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainFragmentViewModel::class) // PROVIDE YOUR OWN MODELS HERE
    internal abstract fun bindEditPlaceViewModel(editPlaceViewModel: MainFragmentViewModel): ViewModel

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}