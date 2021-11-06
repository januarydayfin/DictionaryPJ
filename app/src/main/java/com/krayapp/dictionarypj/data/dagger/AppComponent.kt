package com.krayapp.dictionarypj.data.dagger

import android.content.Context
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.krayapp.dictionarypj.DictionaryApp
import com.krayapp.dictionarypj.ISchedulers
import com.krayapp.dictionarypj.data.dagger.module.MainModule
import com.krayapp.dictionarypj.data.dagger.module.RemoteApiModule
import com.krayapp.dictionarypj.data.dagger.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(modules = [AndroidInjectionModule::class, MainModule::class, RemoteApiModule::class, ViewModelModule::class])
interface AppComponent: AndroidInjector<DictionaryApp> {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: ISchedulers): Builder


        fun build(): AppComponent
    }
}