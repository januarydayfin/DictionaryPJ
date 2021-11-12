package com.krayapp.dictionarypj

import android.app.Application
import com.krayapp.dictionarypj.data.Koin
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DictionaryApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@DictionaryApp)
            modules(Koin.getModule())
        }
    }
}