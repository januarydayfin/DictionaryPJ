package com.krayapp.dictionarypj

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.krayapp.dictionarypj.data.Koin
import com.krayapp.dictionarypj.data.dagger.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import org.koin.core.context.startKoin

class DictionaryApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(Koin.getModule())
        }
    }
}