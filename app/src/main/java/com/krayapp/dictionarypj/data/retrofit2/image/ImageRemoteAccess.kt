package com.krayapp.dictionarypj.data.retrofit2.image

import com.krayapp.dictionarypj.DictionaryApp
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ImageRemoteAccess {
    @Headers("Authorization: ${DictionaryApp.API_KEY}")
    @GET("search")
    fun getImageFromApi(
        @Query("query") imageByLetter:String
    ):retrofit2.Call<ImageDTO>
}