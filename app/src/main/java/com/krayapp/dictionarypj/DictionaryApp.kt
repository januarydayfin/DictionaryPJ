package com.krayapp.dictionarypj

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DictionaryApp: Application() {

    companion object{
        const val API_KEY = "563492ad6f917000010000010ba783552c754973b3f61180b87dee52"
    }
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@DictionaryApp)
            modules(Koin.getModule())
        }
    }
}