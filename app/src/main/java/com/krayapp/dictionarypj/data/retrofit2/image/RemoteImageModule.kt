package com.krayapp.dictionarypj.data.retrofit2.image

import com.krayapp.dictionarypj.data.retrofit2.letter.RemoteAccess
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteImageModule {
    private val baseUrl: String =
        "https://api.pexels.com/v1/"

    fun getFromApi(): ImageRemoteAccess =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()
            .create(ImageRemoteAccess::class.java)
}