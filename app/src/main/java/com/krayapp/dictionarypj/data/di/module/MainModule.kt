package com.krayapp.dictionarypj.data.di.module

import com.krayapp.dictionarypj.MainActivity
import com.krayapp.dictionarypj.view.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainModule {
    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindMovieFragment(): MainFragment
}