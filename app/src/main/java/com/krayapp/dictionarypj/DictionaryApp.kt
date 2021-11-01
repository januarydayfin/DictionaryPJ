package com.krayapp.dictionarypj

import android.app.Application
import androidx.fragment.app.FragmentManager
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import com.krayapp.dictionarypj.data.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class DictionaryApp: DaggerApplication() {

    companion object{
        lateinit var instance:DictionaryApp
    }
    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router

    override fun onCreate() {

        instance = this
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()
                withNavigatorHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
                withSchedulers(MySchedulers())
            }
            .build()

}