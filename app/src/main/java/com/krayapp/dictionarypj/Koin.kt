package com.krayapp.dictionarypj

import androidx.room.Room
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.krayapp.datamodule.data.IImageLoader
import com.krayapp.datamodule.data.ILetterRepo
import com.krayapp.datamodule.data.ImageLoaderImpl
import com.krayapp.datamodule.data.LetterRepoImpl
import com.krayapp.datamodule.data.retrofit2.image.ImageRemoteAccess
import com.krayapp.datamodule.data.retrofit2.image.RemoteImageModule
import com.krayapp.datamodule.data.retrofit2.letter.RemoteAccess
import com.krayapp.datamodule.data.retrofit2.letter.RemoteApiModule
import com.krayapp.datamodule.data.room.ILetterDataBase
import com.krayapp.datamodule.data.room.LetterDataBase
import com.krayapp.datamodule.data.room.LetterDataBaseImpl
import com.krayapp.dictionarypj.viewmodel.AboutLetterViewModel
import com.krayapp.dictionarypj.viewmodel.InLetterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

object Koin {
    private val cicerone = Cicerone.create()
    fun getModule() = module {
        scope(named("viewModelDataScope")) {
            scoped<ILetterRepo> { LetterRepoImpl(api = get()) }
            scoped<ILetterDataBase> { LetterDataBaseImpl(db = get()) }
        }
        single<Router> { cicerone.router }
        single<RemoteAccess> { RemoteApiModule().getFromApi() }
        single<ImageRemoteAccess> { RemoteImageModule().getFromApi() }
        //single<ILetterRepo> { LetterRepoImpl(api = get()) }
        single<NavigatorHolder> { cicerone.getNavigatorHolder() }
        single<LetterDataBase> {
            Room.databaseBuilder(
                androidContext(),
                LetterDataBase::class.java,
                "letterDb.db"
            )
                .build()
        }
        //single <ILetterDataBase>{ LetterDataBaseImpl(db = get()) }
        single<IImageLoader> { ImageLoaderImpl(api = get()) }
        viewModel { AboutLetterViewModel(router = get()) }
        viewModel { InLetterViewModel(api = get()) }
    }
}