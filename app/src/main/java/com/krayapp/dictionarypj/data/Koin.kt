package com.krayapp.dictionarypj.data

import androidx.room.Room
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.krayapp.dictionarypj.data.retrofit2.RemoteAccess
import com.krayapp.dictionarypj.data.room.ILetterDataBase
import com.krayapp.dictionarypj.data.room.LetterDataBase
import com.krayapp.dictionarypj.data.room.LetterDataBaseImpl
import com.krayapp.dictionarypj.viewmodel.AboutLetterViewModel
import org.koin.android.ext.koin.androidContext
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
        single<LetterDataBase> { Room.databaseBuilder(androidContext(),LetterDataBase::class.java, "letterDb.db")
            .build()}
        single <ILetterDataBase>{ LetterDataBaseImpl(db = get()) }
        viewModel { AboutLetterViewModel(repo = get(),database = get()) }
    }
}