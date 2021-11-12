package com.krayapp.dictionarypj.data

import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.krayapp.dictionarypj.data.retrofit2.RemoteAccess
import com.krayapp.dictionarypj.viewmodel.MainFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object Koin {
    private val cicerone = Cicerone.create()
    fun getModule() = module {
        single<RemoteAccess> { RemoteApiModule().getFromApi() }
        single<ILetterRepo> { LetterRepoImpl(api = get()) }
        single<NavigatorHolder> {
            cicerone
                .getNavigatorHolder()
        }
        single<Router>{
            cicerone.router
        }
        viewModel { MainFragmentViewModel(repo = get()) }
    }
}