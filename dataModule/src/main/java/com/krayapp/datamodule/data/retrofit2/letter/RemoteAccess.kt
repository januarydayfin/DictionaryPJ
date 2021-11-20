package com.krayapp.datamodule.data.retrofit2.letter

import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteAccess {
    @GET("words/search")
    fun getLetterInfo(
        @Query ("search")search:String
    ):retrofit2.Call<List<LetterInfo>>
}