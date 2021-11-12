package com.krayapp.dictionarypj.data.di.module

import com.krayapp.dictionarypj.data.retrofit2.RemoteAccess
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RemoteApiModule {
    @Reusable
    @Provides
    fun getFromApi(): RemoteAccess =
        Retrofit.Builder()
            .baseUrl("https://dictionary.skyeng.ru/api/public/v1/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(RemoteAccess::class.java)
}