package com.krayapp.dictionarypj.data

import com.krayapp.dictionarypj.data.retrofit2.RemoteAccess
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteApiModule {
    private val baseUrl:String = "https://dictionary.skyeng.ru/api/public/v1/"
    fun getFromApi(): RemoteAccess =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(RemoteAccess::class.java)
}