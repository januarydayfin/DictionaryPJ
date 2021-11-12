package com.krayapp.dictionarypj.data.dagger.module

import com.krayapp.dictionarypj.MainActivity
import com.krayapp.dictionarypj.data.ILetterRepo
import com.krayapp.dictionarypj.data.LetterRepoImpl
import com.krayapp.dictionarypj.view.MainFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainModule {
    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindMovieFragment(): MainFragment

    @Binds
    fun bindLetterRepo(letterRepo:LetterRepoImpl):ILetterRepo
}